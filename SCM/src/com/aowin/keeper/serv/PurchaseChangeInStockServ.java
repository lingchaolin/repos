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
//		�Ȼ�ȡ״̬��
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
		//ʱ��
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
		//�û���
		HttpSession session=request.getSession();
		String user=(String) session.getAttribute("user");
		pud.changeInStock(poid,num,date,user);
		ArrayList<RecordModel> rList=pud.getInStockRecordList(poid);
		for(int i=0;i<rList.size();i++) {
			pud.addRecordInStockSql(rList.get(i));//�����ⵥ--
			String productCode=rList.get(i).getProductCode();//��ȡ��Ʒ���
			int number=rList.get(i).getStockNum();//�õ��ò�Ʒ��Ҫ��������
			ProductInStockMessage pdsm=pud.getProductStockMessageSql(productCode);
			String name=pdsm.getName();
			String unitName=pdsm.getUnitName();
			boolean flag=pud.isExistStockInStockSql(productCode);
			if(flag) {//����У��޸�----�������ۼ�---��ǰ�߷�������
				pud.modifyStockInStockSql(number, productCode);
			}else {//���
				pud.addStockInStockSql(productCode, name, unitName, number);
			}
			//���²�Ʒ��
			pud.modifyProductInStockSql(number, productCode);
		}
		response.sendRedirect("PurchaseShowInStockMain?getPayType="+getPayType);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
