package com.aowin.keeper.serv;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aowin.dao.PurchaseUserDao;
import com.aowin.keeper.model.RecordModel;

public class PurchaseAddToCheckStock extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String productCode=request.getParameter("getProductCode");	
		int originNum= Integer.parseInt(request.getParameter("getStockNum"));
		int realNum = 0;
		int number=Integer.parseInt(request.getParameter("changeNumForm"));
		String description=request.getParameter("changeReasonForm");
		String type=request.getParameter("changeTypeForm");
		String createUser=(String) request.getSession().getAttribute("user");
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		String stockTime=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
		System.out.println("type:"+type);
//		System.out.println();
		if("���".equals(type)) {System.out.println("���");
			realNum=originNum-number;
			//���-��д����ǼǱ�
			RecordModel rosm=new RecordModel();
			rosm.setProductCode(productCode);
			rosm.setStockNum(number);
			rosm.setStockType(203);
			rosm.setStockTime(stockTime);
			rosm.setCreateUser(createUser);
			PurchaseUserDao.addInventoryOutStockSql(rosm);
			number=-number;//�ڳ���ǼǱ�����ָ�Ϊ�����������޸���;�ɹ���
		}else if("����".equals(type)) {System.out.println("����");
			realNum=originNum+number;
			//����-��д���ǼǱ�
			RecordModel rism=new RecordModel();
			rism.setProductCode(productCode);
			rism.setStockNum(number);
			rism.setStockType(201);
			rism.setStockTime(stockTime);
			rism.setCreateUser(createUser);
			PurchaseUserDao.addInventoryInStockSql(rism);
		}
		PurchaseUserDao.addCheckStockInStockSql(productCode, originNum, realNum, stockTime, createUser, description, type);
		//�ڿ������޸�
		PurchaseUserDao.modifyStockInStockSql(number, productCode);
		//��ת
		response.sendRedirect("PurchaseGetStockInventoryMessage");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
