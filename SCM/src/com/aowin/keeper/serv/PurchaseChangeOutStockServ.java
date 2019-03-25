package com.aowin.keeper.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.aowin.manager.model.AccountMessage;
import com.aowin.manager.model.Page;

public class PurchaseChangeOutStockServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String soid=request.getParameter("getOutStock");
//		先获取状态码
		PurchaseUserDao pud=new PurchaseUserDao();
		int status=PurchaseUserDao.getSomainStatusSql(soid);
		int num=2;//出库--发货--新单据
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
		//添加出库单--
		ArrayList<RecordModel> rList=pud.getOutStockRecordList(soid);
		PrintWriter out=response.getWriter();
		for(int i=0;i<rList.size();i++) {
			String productCode=rList.get(i).getProductCode();//获取产品编号
			int number=rList.get(i).getStockNum();//得到该产品的要出库的数量
			int flagnum=PurchaseUserDao.stockNumStockInStockSql(productCode);//是否存在该商品
			if(flagnum<=0) {//如果没有--没有 库存，不能出库//跳转页面
				out.print("<html>");
				out.print("<head>");
				out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
				out.print("</head>");
				out.print("<body>");
				out.print("没有库存");
				out.print("</body>");
				out.print("</html>");
				out.flush();
				out.close();
				return;
			}else if(flagnum<number) {//库存不够//跳转页面
				out.print("<html>");
				out.print("<head>");
				out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
				out.print("</head>");
				out.print("<body>");
				out.print("库存不足");
				out.print("</body>");
				out.print("</html>");
				out.flush();
				out.close();
				return;
			}//如果有任何商品库存不足，立即跳出，不会修改数据库
		}
		pud.changeOutStock(soid,num,date,user);//更新销售单，要确保在有库存的情况下才更新销售单；
		rList=pud.getOutStockRecordList(soid);//前边没有更新时间，这里更新时间
		for(int i=0;i<rList.size();i++) {
			pud.addRecordOutStockSql(rList.get(i));//添加出库单
			String productCode=rList.get(i).getProductCode();//获取产品编号
			int number=rList.get(i).getStockNum();//得到该产品的要出库的数量
			ProductInStockMessage pdsm=pud.getProductStockMessageSql(productCode);
			String name=pdsm.getName();
			String unitName=pdsm.getUnitName();
			boolean flag=pud.isExistStockInStockSql(productCode);//查看库存中是否有该商品的记录
			if(flag) {//如果有(肯定会有啊)，修改----将数字累加---在前边返回数量
				pud.modifyStockOutStockSql(number, productCode);
				pud.modifyProductOutStockSql(number, productCode);//预销售数减少
			}
		}
		response.sendRedirect("PurchaseShowOutStockMain?getPayType="+getPayType);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
