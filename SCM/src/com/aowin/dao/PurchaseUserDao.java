package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.keeper.model.ForInventoryShowModel;
import com.aowin.keeper.model.MainModle;
import com.aowin.keeper.model.ProductInStockMessage;
import com.aowin.keeper.model.RecordModel;
import com.aowin.sell.model.SubModelNew;
import com.aowin.util.Dbutil;

public class PurchaseUserDao {
	//显示初始的入库数据
		public static ArrayList<MainModle> getShowInstockMain(String str) {
			Connection conn=Dbutil.getConn();
			String sql="SELECT pomain.poid,CreateTime,vender. NAME,scmuser. NAME, TipFee,ProductTotal,pototal,PayType,PrePayFee, pomain. STATUS FROM pomain,scmuser,vender\r\n" + 
					"WHERE pomain.account = scmuser.account \r\n" + 
					"AND pomain.VenderCode = vender.VenderCode\r\n" + 
					"and ((pomain.status=1 and pomain.payType='货到付款') or (pomain.status=3 and pomain.PayType='款到发货') or (pomain.status=5 and pomain.PayType='预付款到发货'))\r\n" + 
					"and PayType=?";
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArrayList<MainModle> list=new ArrayList<MainModle>();
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, str);
				rs=ps.executeQuery();
				while(rs.next()) {
					String poid=rs.getString(1);
					String createTime=rs.getString(2);
					String venderName=rs.getString(3);
					String userName=rs.getString(4);
					double  tipFee=rs.getDouble(5);
					double productTotal=rs.getDouble(6);
					double poTotal=rs.getDouble(7);
					String payType=rs.getString(8);
					double prePayFee=rs.getDouble(9);
					 int status=rs.getInt(10);
					 MainModle pmm=new MainModle(poid, createTime, venderName, userName, tipFee, productTotal,poTotal,payType, prePayFee, status);
					list.add(pmm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return list;
		}
		//显示初始的出库数据
				public static ArrayList<MainModle> getSomainStockSql(String str) {
					Connection conn=Dbutil.getConn();
					String sql="SELECT somain.soid,CreateTime,customer. NAME,scmuser. NAME, TipFee,ProductTotal,sototal,PayType,PrePayFee, somain.STATUS FROM somain,scmuser,customer \r\n" + 
							"WHERE somain.account = scmuser.account\r\n" + 
							"AND somain.CustomerCode = Customer.CustomerCode \r\n" + 
							"and ((somain.status=1 and somain.payType='货到付款') or (somain.status=3 and somain.PayType='款到发货') or (somain.status=5 and somain.PayType='预付款到发货')) \r\n" + 
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
				//获取入库单中的状态码--付款方式
		public static int getPomainStatusSql(String poid) {
			Connection conn=Dbutil.getConn();
			String sql="select status from pomain where poid=?" ;
			PreparedStatement ps=null;
			ResultSet rs=null;
			int status = 0;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, poid);
				rs=ps.executeQuery();
				while(rs.next()) {
					status=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return status;
		}
		//获取入库单中的状态码--付款方式
				public static int getSomainStatusSql(String soid) {
					Connection conn=Dbutil.getConn();
					String sql="select status from somain where soid=?" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					int status = 0;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, soid);
						rs=ps.executeQuery();
						while(rs.next()) {
							status=rs.getInt(1);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return status;
				}
				//入库时更新采购单
		public static void changeInStock(String poid,int status,String date,String user) {
			Connection conn=Dbutil.getConn();
			String sql="update pomain set status=?,stocktime=?,stockuser=?  where poid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, status);
				ps.setString(2, date);
				ps.setString(3, user);
				ps.setString(4, poid);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//出库时更新采购单
		public static void changeOutStock(String poid,int status,String date,String user) {
			Connection conn=Dbutil.getConn();
			String sql="update somain set status=?,stocktime=?,stockuser=?  where soid=?";
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, status);
				ps.setString(2, date);
				ps.setString(3, user);
				ps.setString(4, poid);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//获取采购单明细
		public static ArrayList<SubModelNew> getPoitemStockSql(String str) {
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
					SubModelNew psm=new SubModelNew(productCode, name, unitName, num, unitPrice, itemPrice);
					list.add(psm);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return list;
		}
		//获取销售单明细
				public static ArrayList<SubModelNew> getSoitemStockSql(String str) {
					Connection conn=Dbutil.getConn();
					String sql="select soitem.ProductCode,product.name,soitem.unitname,num,unitprice,itemprice from soitem,product where soitem.ProductCode=product.ProductCode and  soid=?" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					System.out.println("dao:"+str);
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
							SubModelNew psm=new SubModelNew(productCode, name, unitName, num, unitPrice, itemPrice);
							list.add(psm);						
						}
						System.out.println("dao:"+list.size());
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return list;
				}
		//从数据库中读取入库登记需要的数据-
		public static RecordModel getInStockRecordSql(String poid) {
			Connection conn=Dbutil.getConn();
			String sql="select productcode,sum(num),status,stocktime,stockuser from pomain,poitem where pomain.poid=poitem.poid and pomain.poid=?" ;
			PreparedStatement ps=null;
			ResultSet rs=null;
			RecordModel pism = null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, poid);
				rs=ps.executeQuery();
				if(rs.next()) {
					String productCode=rs.getString(1);
					String orderCode=poid;
					int stockNum=rs.getInt(2);
					//新发现，入库类型--采购入库和盘点入库
//					int stockType=rs.getInt(3);
					int stockType=200;
					String  stockTime=rs.getString(4);
					String  createUser=rs.getString(5);
					pism=new RecordModel(productCode, orderCode, stockNum, stockType, stockTime, createUser);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(rs, ps, conn);
			}
			return pism;
		}
		//从数据库中读取入库登记需要的数据--但读取的可能是一连串的数据--改用ArrayList
				public static ArrayList<RecordModel> getInStockRecordList(String poid) {
					Connection conn=Dbutil.getConn();
					String sql="select productcode,sum(num),status,stocktime,stockuser from pomain,poitem where pomain.poid=poitem.poid and pomain.poid=? GROUP BY poitem.ProductCode" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					ArrayList<RecordModel> list=new ArrayList<RecordModel>();
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, poid);
						rs=ps.executeQuery();
						while(rs.next()) {
							String productCode=rs.getString(1);
							String orderCode=poid;
							int stockNum=rs.getInt(2);
							int stockType=200;
							String  stockTime=rs.getString(4);
							String  createUser=rs.getString(5);
							RecordModel pism=new RecordModel(productCode, orderCode, stockNum, stockType, stockTime, createUser);
							list.add(pism);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return list;
				}
		//从数据库中读取出库登记需要的数据
				public static RecordModel getRecordOutStockSql(String poid) {
					Connection conn=Dbutil.getConn();
					String sql="select productcode,sum(num),status,stocktime,stockuser from somain,soitem where somain.soid=soitem.soid and somain.soid=?" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					RecordModel posm = null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, poid);
						rs=ps.executeQuery();
						if(rs.next()) {
							String productCode=rs.getString(1);
							String orderCode=poid;
							int stockNum=rs.getInt(2);
							//新发现，入库类型--采购入库和盘点入库
//							int stockType=rs.getInt(3);
							int stockType=202;
							String  stockTime=rs.getString(4);
							String  createUser=rs.getString(5);
							posm=new RecordModel(productCode, orderCode, stockNum, stockType, stockTime, createUser);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return posm;
				}
				//从数据库中读取出库登记需要的数据--但读取的可能是一连串的数据--改用ArrayList
				public static ArrayList<RecordModel> getOutStockRecordList(String soid) {
					Connection conn=Dbutil.getConn();
					String sql="select productcode,sum(num),status,stocktime,stockuser from somain,soitem where somain.soid=soitem.soid and somain.soid=? GROUP BY soitem.ProductCode" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					ArrayList<RecordModel> list=new ArrayList<RecordModel>();
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, soid);
						rs=ps.executeQuery();
						while(rs.next()) {
							String productCode=rs.getString(1);
							String orderCode=soid;
							int stockNum=rs.getInt(2);
							int stockType=200;
							String  stockTime=rs.getString(4);
							String  createUser=rs.getString(5);
							RecordModel pism=new RecordModel(productCode, orderCode, stockNum, stockType, stockTime, createUser);
							list.add(pism);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return list;
				}
//		填写入库登记表
		public static void addRecordInStockSql(RecordModel rsm) {
			Connection conn=Dbutil.getConn();
			String sql="insert into instockrecord (productCode,ordercode,stocknum,stocktype,stocktime,createuser)values(?,?,?,?,?,?)" ;
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, rsm.getProductCode());
				ps.setString(2, rsm.getOrderCode());
				ps.setInt(3, rsm.getStockNum());
				ps.setInt(4, rsm.getStockType().equals("采购入库")?200:201);
				ps.setString(5, rsm.getStockTime());
				ps.setString(6, rsm.getCreateUser());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
//	盘点入库登记表
		public static void addInventoryInStockSql(RecordModel rsm) {
			Connection conn=Dbutil.getConn();
			String sql="insert into instockrecord (productcode,stocknum,stocktype,stocktime,createuser)values(?,?,?,?,?)" ;
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, rsm.getProductCode());
				ps.setInt(2, rsm.getStockNum());
				ps.setInt(3, rsm.getStockType().equals("采购入库")?200:201);
				ps.setString(4, rsm.getStockTime());
				ps.setString(5, rsm.getCreateUser());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
//		填写出库登记表
		public static void addRecordOutStockSql(RecordModel rsm) {
			Connection conn=Dbutil.getConn();
			String sql="insert into outstockrecord (productCode,ordercode,stocknum,stocktype,stocktime,createuser)values(?,?,?,?,?,?)" ;
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, rsm.getProductCode());
				ps.setString(2, rsm.getOrderCode());
				ps.setInt(3, rsm.getStockNum());
				ps.setInt(4, rsm.getStockType().equals("销售出库")?202:203);
				ps.setString(5, rsm.getStockTime());
				ps.setString(6, rsm.getCreateUser());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
//		盘点出库登记表
		public static void addInventoryOutStockSql(RecordModel rsm) {
			Connection conn=Dbutil.getConn();
			String sql="insert into outstockrecord (productcode,stocknum,stocktype,stocktime,createuser)values(?,?,?,?,?)" ;
			PreparedStatement ps=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, rsm.getProductCode());
				ps.setInt(2, rsm.getStockNum());
				ps.setInt(3, rsm.getStockType().equals("销售出库")?202:203);
				ps.setString(4, rsm.getStockTime());
				ps.setString(5, rsm.getCreateUser());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				Dbutil.close(null, ps, conn);
			}
		}
		//stock中是否存在该商品
				public static boolean isExistStockInStockSql(String productCode) {
					Connection conn=Dbutil.getConn();
					String sql="select * from stock where productcode=?" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, productCode);
						rs=ps.executeQuery();
						return rs.next();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return false;
				}
				//stock中是否存在该商品
				public static int stockNumStockInStockSql(String productCode) {
					Connection conn=Dbutil.getConn();
					String sql="select num from stock where productcode=?" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					int num=-1;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, productCode);
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
				//product中获取数据
				public static ProductInStockMessage getProductStockMessageSql(String productCode) {
					Connection conn=Dbutil.getConn();
					String sql="select name,unitname,ponum,sonum from product where productcode=?" ;
					PreparedStatement ps=null;
					ResultSet rs=null;
					ProductInStockMessage rism=null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, productCode);
						rs=ps.executeQuery();
						if(rs.next()) {
							String name=rs.getString(1);
							String unitName=rs.getString(2);
							int poNum=rs.getInt(3);
							int soNum=rs.getInt(4);
							rism=new ProductInStockMessage(name, unitName, poNum, soNum);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(rs, ps, conn);
					}
					return rism;
				}
//				修改库存表--入库
				public static void modifyStockInStockSql(int number,String productCode) {
					Connection conn=Dbutil.getConn();
					String sql="update stock set num=num+? where productcode=?" ;
					PreparedStatement ps=null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setInt(1, number);
						ps.setString(2, productCode);
						ps.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(null, ps, conn);
					}
				}
//				修改库存表--出库
				public static void modifyStockOutStockSql(int number,String productCode) {
					Connection conn=Dbutil.getConn();
					String sql="update stock set num=num-? where productcode=?" ;
					PreparedStatement ps=null;
					try {
						ps=conn.prepareStatement(sql);
						ps.setInt(1, number);
						ps.setString(2, productCode);
						ps.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						Dbutil.close(null, ps, conn);
					}
				}
//				添加库存表数据
			public static void addStockInStockSql(String productCode,String name,String unitName,int number ) {
				Connection conn=Dbutil.getConn();
				String sql="insert into stock (productcode,name,unitname,num) values (?,?,?,?)" ;
				PreparedStatement ps=null;
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, productCode);
					ps.setString(2, name);
					ps.setString(3, unitName);
					ps.setInt(4, number);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(null, ps, conn);
				}
			}
//			修改产品表--入库--采购在途数减少
			public static void modifyProductInStockSql(int number,String productCode) {
				Connection conn=Dbutil.getConn();
				String sql="update product set ponum=ponum-? where productcode=?" ;
				PreparedStatement ps=null;
				try {
					ps=conn.prepareStatement(sql);
					ps.setInt(1, number);
					ps.setString(2, productCode);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(null, ps, conn);
				}
			}
//			修改产品表--出库--预销售数减少
			public static void modifyProductOutStockSql(int number,String productCode) {
				Connection conn=Dbutil.getConn();
				String sql="update product set sonum=sonum-? where productcode=?" ;
				PreparedStatement ps=null;
				try {
					ps=conn.prepareStatement(sql);
					ps.setInt(1, number);
					ps.setString(2, productCode);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(null, ps, conn);
				}
			}
			//多表查询for盘点
			public static ArrayList<ForInventoryShowModel> getInventoryShowMessageSql() {
				Connection conn=Dbutil.getConn();
				String sql="select stock.ProductCode,stock.name,num,ponum,sonum from product,stock where product.ProductCode=stock.ProductCode" ;
				PreparedStatement ps=null;
				ResultSet rs=null;
				ArrayList<ForInventoryShowModel> fList=new ArrayList<ForInventoryShowModel>();
				try {
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()) {
						String productcode=rs.getString(1);
						String name=rs.getString(2);
						int num=rs.getInt(3);
						int ponum=rs.getInt(4);
						int sonum=rs.getInt(5);
						ForInventoryShowModel fism=new ForInventoryShowModel(productcode, name, num, ponum, sonum);
						fList.add(fism);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(rs, ps, conn);
				}
				return fList;
			}
			//多表查询for盘点---分页limit
			public static ArrayList<ForInventoryShowModel> getInvMessageLim(int no) {
				Connection conn=Dbutil.getConn();
				String sql="select stock.ProductCode,stock.name,num,ponum,sonum from product,stock where product.ProductCode=stock.ProductCode limit ?,5" ;
				PreparedStatement ps=null;
				ResultSet rs=null;
				ArrayList<ForInventoryShowModel> fList=new ArrayList<ForInventoryShowModel>();
				try {
					ps=conn.prepareStatement(sql);
					ps.setInt(1, no);
					rs=ps.executeQuery();
					while(rs.next()) {
						String productcode=rs.getString(1);
						String name=rs.getString(2);
						int num=rs.getInt(3);
						int ponum=rs.getInt(4);
						int sonum=rs.getInt(5);
						ForInventoryShowModel fism=new ForInventoryShowModel(productcode, name, num, ponum, sonum);
						fList.add(fism);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(rs, ps, conn);
				}
				return fList;
			}
			
			//多表查询for查询
			public static ArrayList<ForInventoryShowModel> getQueryShowMessageSql(String str) {
				Connection conn=Dbutil.getConn();
				String sql="select stock.ProductCode,stock.name,num,ponum,sonum from product,stock where product.ProductCode=stock.ProductCode"+str ;
				PreparedStatement ps=null;
				ResultSet rs=null;
				ArrayList<ForInventoryShowModel> fList=new ArrayList<ForInventoryShowModel>();
				try {
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					while(rs.next()) {
						String productcode=rs.getString(1);
						String name=rs.getString(2);
						int num=rs.getInt(3);
						int ponum=rs.getInt(4);
						int sonum=rs.getInt(5);
						ForInventoryShowModel fism=new ForInventoryShowModel(productcode, name, num, ponum, sonum);
						fList.add(fism);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(rs, ps, conn);
				}
				return fList;
			}
//			向盘点表添加数据
			public static void addCheckStockInStockSql(String productCode,int originNum,int realNum,String stockTime,String createUser,String description,String type) {
				Connection conn=Dbutil.getConn();
				String sql="insert into checkstock (productCode,originNum,realNum,stockTime,createUser,description,type) values(?,?,?,?,?,?,?)";
				PreparedStatement ps=null;
				try {
					System.out.println("执行sql");
					ps=conn.prepareStatement(sql);
					ps.setString(1, productCode);
					ps.setInt(2, originNum);
					ps.setInt(3, realNum);
					ps.setString(4, stockTime);
					ps.setString(5, createUser);
					ps.setString(6, description);
					ps.setString(7, type);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(null, ps, conn);
				}
			}
//			读取入库表的数据
			public static ArrayList<RecordModel> getRecordInStockSql(String productCode) {
				Connection conn=Dbutil.getConn();
				String sql="select stocktime,ordercode,CreateUser,stocknum,stocktype from instockrecord where ProductCode=?";
				PreparedStatement ps=null;
				ResultSet rs=null;
				ArrayList<RecordModel> list=new ArrayList<RecordModel>();
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, productCode);
					rs=ps.executeQuery();
					while(rs.next()) {
						productCode=null;
						String stockTime=rs.getString(1);
						String orderCode=rs.getString(2);
						String createUser=rs.getString(3);
						int stockNum=rs.getInt(4);
						int stockType=rs.getInt(5);
						RecordModel rism=new RecordModel(productCode, orderCode, stockNum, stockType, stockTime, createUser);
						list.add(rism);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(null, ps, conn);
				}
				return list;
			}
//			读取出库表的数据
			public static ArrayList<RecordModel> getOutStockRecordSql(String productCode) {
				Connection conn=Dbutil.getConn();
				String sql="select stocktime,ordercode,CreateUser,stocknum,stocktype from outstockrecord where ProductCode=?";
				PreparedStatement ps=null;
				ResultSet rs=null;
				ArrayList<RecordModel> list=new ArrayList<RecordModel>();
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, productCode);
					rs=ps.executeQuery();
					while(rs.next()) {
						productCode=null;
						String stockTime=rs.getString(1);
						String orderCode=rs.getString(2);
						String createUser=rs.getString(3);
						int stockNum=rs.getInt(4);
						int stockType=rs.getInt(5);
						RecordModel rism=new RecordModel(productCode, orderCode, stockNum, stockType, stockTime, createUser);
						list.add(rism);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					Dbutil.close(null, ps, conn);
				}
				return list;
			}
}
