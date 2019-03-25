package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.ProductInStockMessage;
import com.aowin.keeper.model.RecordModel;

public class PurchaseChangeInStockServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poid=request.getParameter("getInStock");
//		先获取状态码
		PurchaseUserDao pud=new PurchaseUserDao();
		int status=pud.getPomainStatusSql(poid);
		int num=2;
		int getPayType=110;
		if(status==1) {
		}else if(status==3) {
			getPayType=120;
		}else if(status==5) {
			getPayType=130;
		}
		//时间
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
		//用户名
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		pud.changeInStock(poid,num,date,user);
		ArrayList<RecordModel> rList=pud.getInStockRecordList(poid);
		for(int i=0;i<rList.size();i++) {
			pud.addRecordInStockSql(rList.get(i));//添加入库单--
			String productCode=rList.get(i).getProductCode();//获取产品编号
			int number=rList.get(i).getStockNum();//得到该产品的要入库的数量
			ProductInStockMessage pdsm=pud.getProductStockMessageSql(productCode);
			String name=pdsm.getName();
			String unitName=pdsm.getUnitName();
			boolean flag=pud.isExistStockInStockSql(productCode);
			if(flag) {//如果有，修改----将数字累加---在前边返回数量
				pud.modifyStockInStockSql(number, productCode);
			}else {//添加
				pud.addStockInStockSql(productCode, name, unitName, number);
			}
			//更新产品表
			pud.modifyProductInStockSql(number, productCode);
		}
		response.sendRedirect("PurchaseShowInStockMain?getPayType="+getPayType);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
