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
//		�Ȼ�ȡ״̬��
		PurchaseUserDao pud=new PurchaseUserDao();
		int status=PurchaseUserDao.getSomainStatusSql(soid);
		int num=2;//����--����--�µ���
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
		//��ӳ��ⵥ--
		ArrayList<RecordModel> rList=pud.getOutStockRecordList(soid);
		PrintWriter out=response.getWriter();
		for(int i=0;i<rList.size();i++) {
			String productCode=rList.get(i).getProductCode();//��ȡ��Ʒ���
			int number=rList.get(i).getStockNum();//�õ��ò�Ʒ��Ҫ���������
			int flagnum=PurchaseUserDao.stockNumStockInStockSql(productCode);//�Ƿ���ڸ���Ʒ
			if(flagnum<=0) {//���û��--û�� ��棬���ܳ���//��תҳ��
				out.print("<html>");
				out.print("<head>");
				out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
				out.print("</head>");
				out.print("<body>");
				out.print("û�п��");
				out.print("</body>");
				out.print("</html>");
				out.flush();
				out.close();
				return;
			}else if(flagnum<number) {//��治��//��תҳ��
				out.print("<html>");
				out.print("<head>");
				out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
				out.print("</head>");
				out.print("<body>");
				out.print("��治��");
				out.print("</body>");
				out.print("</html>");
				out.flush();
				out.close();
				return;
			}//������κ���Ʒ��治�㣬���������������޸����ݿ�
		}
		pud.changeOutStock(soid,num,date,user);//�������۵���Ҫȷ�����п�������²Ÿ������۵���
		rList=pud.getOutStockRecordList(soid);//ǰ��û�и���ʱ�䣬�������ʱ��
		for(int i=0;i<rList.size();i++) {
			pud.addRecordOutStockSql(rList.get(i));//��ӳ��ⵥ
			String productCode=rList.get(i).getProductCode();//��ȡ��Ʒ���
			int number=rList.get(i).getStockNum();//�õ��ò�Ʒ��Ҫ���������
			ProductInStockMessage pdsm=pud.getProductStockMessageSql(productCode);
			String name=pdsm.getName();
			String unitName=pdsm.getUnitName();
			boolean flag=pud.isExistStockInStockSql(productCode);//�鿴������Ƿ��и���Ʒ�ļ�¼
			if(flag) {//�����(�϶����а�)���޸�----�������ۼ�---��ǰ�߷�������
				pud.modifyStockOutStockSql(number, productCode);
				pud.modifyProductOutStockSql(number, productCode);//Ԥ����������
			}
		}
		response.sendRedirect("PurchaseShowOutStockMain?getPayType="+getPayType);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
