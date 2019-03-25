package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.statement.model.MoneyIOModel;
import com.aowin.statement.model.MoneyMessageModel;
import com.aowin.statement.model.StockNumModel;
import com.aowin.util.Dbutil;

public class StatementUserDao {
	//显示收款总金额和交易次数
	public MoneyIOModel getStatSomainStockSql(String startTime,String endTime) {
		Connection conn=Dbutil.getConn();
		String sql="select sum(sototal),count(*) from somain where paytime between ? and ?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		MoneyIOModel mom=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, startTime);
			ps.setString(2, endTime);
			rs=ps.executeQuery();
			if(rs.next()) {
				int money=rs.getInt(1);
				int time=rs.getInt(2);
				mom=new MoneyIOModel(money,time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return mom;
	}
	//获取明细数据
	public ArrayList<MoneyMessageModel> getStatConsortSomainMess(String startTime,String endTime) {
		Connection conn=Dbutil.getConn();
		String sql="select soid,createtime,paytime,sototal,payuser,status from somain where paytime between ? and ?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<MoneyMessageModel> list=new ArrayList<MoneyMessageModel>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, startTime);
			ps.setString(2, endTime);
			rs=ps.executeQuery();
			while(rs.next()) {
				String noid=rs.getString(1);
				String createTime=rs.getString(2);
				String payTime=rs.getString(3);
				int total=rs.getInt(4);
				String payUser=rs.getString(5);
				int status=rs.getInt(6);
				MoneyMessageModel mom=new MoneyMessageModel(noid, createTime, payTime, total, payUser, status);
				list.add(mom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return list;
	}
	//显示付款总金额和交易次数
	public MoneyIOModel getStatPomainStockSql(String startTime,String endTime) {
		Connection conn=Dbutil.getConn();
		String sql="select sum(pototal),count(*) from pomain where paytime between ? and ?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		MoneyIOModel mom=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, startTime);
			ps.setString(2, endTime);
			rs=ps.executeQuery();
			if(rs.next()) {
				int money=rs.getInt(1);
				int time=rs.getInt(2);
				mom=new MoneyIOModel(money,time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbutil.close(rs, ps, conn);
		}
		return mom;
	}
	//获取付款明细数据
		public ArrayList<MoneyMessageModel> getStatConsortPomainMess(String startTime,String endTime) {
			Connection conn=Dbutil.getConn();
			String sql="select poid,createtime,paytime,pototal,payuser,status from pomain where paytime between ? and ?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<MoneyMessageModel> list=new ArrayList<MoneyMessageModel>();
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, startTime);
				ps.setString(2, endTime);
				rs=ps.executeQuery();
				while(rs.next()) {
					String noid=rs.getString(1);
					String createTime=rs.getString(2);
					String payTime=rs.getString(3);
					int total=rs.getInt(4);
					String payUser=rs.getString(5);
					int status=rs.getInt(6);
					MoneyMessageModel mom=new MoneyMessageModel(noid, createTime, payTime, total, payUser, status);
					list.add(mom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return list;
		}
		//获取库存量
		public int getStockNum(String startTime,String endTime) {
			Connection conn=Dbutil.getConn();
			String sql="select sum(num) from stock where paytime between ? and ?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			int num = 0;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, startTime);
				ps.setString(2, endTime);
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
		}
		//获取库存数据
		public ArrayList<StockNumModel> getStockMessage() {
			Connection conn=Dbutil.getConn();
			String sql="select productcode,name,num from stock ";
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<StockNumModel> list=new ArrayList<StockNumModel>();
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					String productCode=rs.getString(1);
					String name=rs.getString(2);
					int num=rs.getInt(3);
					StockNumModel mom=new StockNumModel(productCode, name, num);
					list.add(mom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return list;
		}
		//获取所有商品的入库数量
		public ArrayList<StockNumModel> getStockMessageIn(String staTime) {
			Connection conn=Dbutil.getConn();
			String sql="select  poitem.productcode,name,sum(stocknum) from instockrecord,poitem,product \r\n" + 
					"where  product.ProductCode=poitem.ProductCode\r\n" + 
					"AND	poitem.poid=instockrecord.OrderCode  \r\n" + 
					"and StockTime>?" + 
					"GROUP BY poitem.productcode ";
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<StockNumModel> list=new ArrayList<StockNumModel>();
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, staTime);
				rs=ps.executeQuery();
				while(rs.next()) {
					String productCode=rs.getString(1);
					String name=rs.getString(2);
					int num=rs.getInt(3);
					StockNumModel mom=new StockNumModel(productCode, name, num);
					list.add(mom);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return list;
		}
		//获取所有商品的出库数量
				public ArrayList<StockNumModel> getStockMessageOut(String staTime) {
					Connection conn=Dbutil.getConn();
					String sql="select  soitem.productcode,name,sum(stocknum) from outstockrecord,soitem,product \r\n" + 
							"where  product.ProductCode=soitem.ProductCode\r\n" + 
							"AND	soitem.soid=outstockrecord.OrderCode  \r\n" + 
							"and StockTime>?" + 
							"GROUP BY soitem.productcode ";
					PreparedStatement ps=null;
					ResultSet rs=null;
					ArrayList<StockNumModel> list=new ArrayList<StockNumModel>();
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, staTime);
						rs=ps.executeQuery();
						while(rs.next()) {
							String productCode=rs.getString(1);
							String name=rs.getString(2);
							int num=rs.getInt(3);
							StockNumModel mom=new StockNumModel(productCode, name, num);
							list.add(mom);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return list;
				}
}
