package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.keeper.model.MainModle;
import com.aowin.sell.model.QueryMoneyModel;
import com.aowin.sell.model.SubModelNew;
import com.aowin.util.Dbutil;

public class ConsortiumUserDao {
	//��ʾ���տ������
	public ArrayList<MainModle> getSomainStockSql(String str) {
		Connection conn=Dbutil.getConn();
		String sql="SELECT somain.soid,CreateTime,customer. NAME,scmuser. NAME, TipFee,ProductTotal,sototal,PayType,PrePayFee, somain.STATUS FROM somain,scmuser,customer \r\n" + 
				"WHERE somain.account = scmuser.account \r\n" + 
				"AND somain.CustomerCode = Customer.CustomerCode \r\n" + 
				"and ((somain.status=2 and somain.payType='��������') or (somain.status=1 and somain.PayType='�����') or ((somain.status=1 or somain.status=2) and somain.PayType='Ԥ�������'))\r\n" + 
				"and PayType=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<MainModle> soList=new ArrayList<MainModle>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, str);
			rs=ps.executeQuery();
			while(rs.next()) {
				String soid=rs.getString(1);
				String createTime=rs.getString(2);
				String customerName=rs.getString(3);
				String userName=rs.getString(4);
				double  tipFee=rs.getDouble(5);
				double productTotal=rs.getDouble(6);
				double soTotal=rs.getDouble(7);
				String payType=rs.getString(8);
				double prePayFee=rs.getDouble(9);
				 int status=rs.getInt(10);
				 MainModle pmm=new MainModle(soid, createTime, customerName, userName, tipFee, productTotal, soTotal, payType, prePayFee, status);
				 soList.add(pmm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return soList;
	}
	//��ʾ�ɸ��������
		public ArrayList<MainModle> getPomainStockSql(String str) {
			Connection conn=Dbutil.getConn();
			String sql="SELECT pomain.poid,CreateTime,vender. NAME,scmuser. NAME, TipFee,ProductTotal,pototal,PayType,PrePayFee, pomain.STATUS FROM pomain,scmuser,vender \r\n" + 
					"WHERE pomain.account = scmuser.account \r\n" + 
					"AND pomain.venderCode = vender.VenderCode \r\n" + 
					"and ((pomain.status=2 and pomain.payType='��������') or (pomain.status=1 and pomain.PayType='�����') or ((pomain.status=1 or pomain.status=2) and pomain.PayType='Ԥ�������'))\r\n" + 
					"and PayType=?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<MainModle> soList=new ArrayList<MainModle>();
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, str);
				rs=ps.executeQuery();
				while(rs.next()) {
					String soid=rs.getString(1);
					String createTime=rs.getString(2);
					String customerName=rs.getString(3);
					String userName=rs.getString(4);
					double  tipFee=rs.getDouble(5);
					double productTotal=rs.getDouble(6);
					double soTotal=rs.getDouble(7);
					String payType=rs.getString(8);
					double prePayFee=rs.getDouble(9);
					 int status=rs.getInt(10);
					 MainModle pmm=new MainModle(soid, createTime, customerName, userName, tipFee, productTotal, soTotal, payType, prePayFee, status);
					 soList.add(pmm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return soList;
		}
	//��ȡ���۵���ϸ
	public ArrayList<SubModelNew> getSoitemStockSql(String str) {
		Connection conn=Dbutil.getConn();
		String sql="select soitem.ProductCode,product.name,soitem.unitname,num,unitprice,itemprice from soitem,product where soitem.ProductCode=product.ProductCode and  soid=?" ;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<SubModelNew> list=new ArrayList<SubModelNew>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, str);
			rs=ps.executeQuery();
			while(rs.next()) {
				//String soid=rs.getString(1);
				String productCode=rs.getString(1);
				String name=rs.getString(2);
				String unitName=rs.getString(3);
				int num=rs.getInt(4);
				double unitPrice=rs.getDouble(5);
				double itemPrice=rs.getDouble(6);
				SubModelNew smn=new SubModelNew(productCode, name, unitName, num, unitPrice, itemPrice);
				list.add(smn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return list;
	}
	//��ȡ�ɹ�����ϸ
	public ArrayList<SubModelNew> getPoitemStockSql(String str) {
		Connection conn=Dbutil.getConn();
		String sql="select poitem.ProductCode,product.name,poitem.unitname,num,unitprice,itemprice from poitem,product where poitem.ProductCode=product.ProductCode and  poid=?" ;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<SubModelNew> list=new ArrayList<SubModelNew>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, str);
			rs=ps.executeQuery();
			while(rs.next()) {
				String productCode=rs.getString(1);
				String name=rs.getString(2);
				String unitName=rs.getString(3);
				int num=rs.getInt(4);
				double unitPrice=rs.getDouble(5);
				double itemPrice=rs.getDouble(6);
				SubModelNew smn=new SubModelNew(productCode, name, unitName, num, unitPrice, itemPrice);
				list.add(smn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return list;
	}
	//��ʾ���۵�����--paytype��status
		public MainModle getSoidMessSql(String str) {
			Connection conn=Dbutil.getConn();
			String sql="select paytype,status from somain where soid=?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			 MainModle pmm=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, str);
				rs=ps.executeQuery();
				if(rs.next()) {
					String payType=rs.getString(1);
					 int status=rs.getInt(2);
					 System.out.println(payType+":"+status);
					 pmm=new MainModle(payType, status);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return pmm;
		}
		//��ʾ�ɹ�������--paytype��status
				public MainModle getPoidMessSql(String str) {
					Connection conn=Dbutil.getConn();
					String sql="select paytype,status from pomain where poid=?";
					PreparedStatement ps=null;
					ResultSet rs=null;
					 MainModle pmm=null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, str);
						rs=ps.executeQuery();
						if(rs.next()) {
							String payType=rs.getString(1);
							 int status=rs.getInt(2);
							 System.out.println(payType+":"+status);
							 pmm=new MainModle(payType, status);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return pmm;
				}
		//�����տ�տ����±��
		public void modifyNormSoamin(String str,String payTime,String payUser) {
			Connection conn=Dbutil.getConn();
			String sql="update somain set status=3,paytime=?,payuser=? where soid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, payTime);
				ps.setString(2, payUser);
				ps.setString(3, str);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//���񸶿�������±��
		public void modifyNormPoamin(String str,String payTime,String payUser) {
			Connection conn=Dbutil.getConn();
			String sql="update pomain set status=3,paytime=?,payuser=? where poid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, payTime);
				ps.setString(2, payUser);
				ps.setString(3, str);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//�����տ��Ԥ�������±��
		public void modifyPreSoamin(String str,String prePayTime,String prePayUser)  {
			Connection conn=Dbutil.getConn();
			String sql="update somain set status=5,paytime=?,payuser=? where soid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, prePayTime);
				ps.setString(2, prePayUser);
				ps.setString(3, str);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//���񸶿��Ԥ�������±��
				public void modifyPrePoamin(String str,String prePayTime,String prePayUser)  {
					Connection conn=Dbutil.getConn();
					String sql="update Pomain set status=5,paytime=?,payuser=? where poid=?";
					PreparedStatement ps=null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, prePayTime);
						ps.setString(2, prePayUser);
						ps.setString(3, str);
						ps.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(null, ps, conn);
					}
				}
		//�˽����۵�
		public void modifyEndSoamin(String str,String endTime,String endUser) {
			Connection conn=Dbutil.getConn();
			String sql="update somain set status=4,endtime=?,enduser=? where soid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, endTime);
				ps.setString(2, endUser);
				ps.setString(3, str);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//�˽�ɹ���
		public void modifyEndPoamin(String str,String endTime,String endUser) {
			Connection conn=Dbutil.getConn();
			String sql="update pomain set status=4,endtime=?,enduser=? where poid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, endTime);
				ps.setString(2, endUser);
				ps.setString(3, str);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//�Ӳɹ�����֧��--��ҳ
		public ArrayList<QueryMoneyModel> getOutMoneyPoamin(String str) {
			Connection conn=Dbutil.getConn();
			String sql="select payTime,poid,pototal,payuser,paytype from pomain where status=3 "+str;
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<QueryMoneyModel> list=new  ArrayList<QueryMoneyModel>();
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					String payTime=rs.getString(1);
					String noid=rs.getString(2);
					double total=rs.getDouble(3);
					String payUser=rs.getString(4);
					String payType=rs.getString(5);
					QueryMoneyModel qmm=new QueryMoneyModel(payTime, noid, total, payUser,payType);
					list.add(qmm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return list;
		}
		//�Ӳɹ���������������
	/*	public int getOutMoneyPoaminNum(String str) {
			Connection conn=Dbutil.getConn();
			String sql="select count(*) from pomain where status=3"+str;
			PreparedStatement ps=null;
			ResultSet rs=null;
			int num=0;
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()) {
					num=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return num;
		}*/
		//�����۵���֧��--��ҳ
				public ArrayList<QueryMoneyModel> getInMoneySoamin(String str) {
					Connection conn=Dbutil.getConn();
					String sql="select payTime,soid,sototal,payuser,paytype from somain where status=3 "+str;
					PreparedStatement ps=null;
					ResultSet rs=null;
					ArrayList<QueryMoneyModel> list=new  ArrayList<QueryMoneyModel>();
					try {
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						while(rs.next()) {
							String payTime=rs.getString(1);
							String noid=rs.getString(2);
							double total=rs.getDouble(3);
							String payUser=rs.getString(4);
							String payType=rs.getString(5);
							QueryMoneyModel qmm=new QueryMoneyModel(payTime, noid, total, payUser,payType);
							list.add(qmm);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return list;
				}
				//�����۵�������������
			/*	public int getInMoneySoaminNum(String str) {
					Connection conn=Dbutil.getConn();
					String sql="select count(*) from somain where status=3"+str;
					PreparedStatement ps=null;
					ResultSet rs=null;
					int num=0;
					try {
						ps=conn.prepareStatement(sql);
						rs=ps.executeQuery();
						if(rs.next()) {
							num=rs.getInt(1);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return num;
				}*/
}
