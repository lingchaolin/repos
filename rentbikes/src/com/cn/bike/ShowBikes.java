package com.cn.bike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cn.bike.BikesVo;
import com.cn.jdbc.JDBC_Connection;

public class ShowBikes {
	public List<BikesVo> showByPage(int page){//分页查询方法
		ResultSet rs = null;
		PreparedStatement pstmt =null;
		Connection conn = null;
		List<BikesVo> list = new ArrayList<BikesVo>();
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "select * from bikes order by id desc limit ?,10";//分页查询的SQL语句，每页显示5条记录
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			while(rs.next()){
				BikesVo bikesVo = new BikesVo();
				//	把各属性放入BikesVo对象中
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("biketype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setDescription(rs.getString("description"));
				
				list.add(bikesVo);//把BikesVo对象放入集合中
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, pstmt);
		}
		return list;
	}
	public int maxpage(){//获取最大页数查询方法
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count =0;//声明一个count变量，用于存储记录数
		int maxpage = 0;//声明一个maxpage变量，原来表示最大页数
		try {
			conn  = JDBC_Connection.getConnection();
			stmt = conn.createStatement();
			String sql ="select count(*) from bikes";//查询总记录数的SQL语句
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);//如果结果集存在，记录数初始化值为1
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);
		}
		maxpage = (count+4)/5;//最大页数等于总记录条数加上4，再除以5
		return maxpage;
	}
	
	public List<BikesVo> showBikes(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BikesVo> list = new ArrayList<BikesVo>();
		try {
			String sql = "select * from bikes";//查询全部SQL语句
			conn = JDBC_Connection.getConnection();//连接数据库
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				BikesVo bikesVo = new BikesVo();
				//把各属性放入CarsVo对象中
				bikesVo.setId(rs.getInt("id"));
				bikesVo.setBikenumber(rs.getString("bikenumber"));
				bikesVo.setBiketype(rs.getString("bikestype"));
				bikesVo.setColor(rs.getString("color"));
				bikesVo.setPrice(rs.getDouble("price"));
				bikesVo.setRentprice(rs.getDouble("rentprice"));
				bikesVo.setDeposit(rs.getDouble("deposit"));
				bikesVo.setIsrenting(rs.getInt("isrenting"));
				bikesVo.setDescription(rs.getString("description"));
				
				list.add(bikesVo);//把CarsVo对象放入集合中
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBC_Connection.free(rs, conn, stmt);//关闭连接
		}
		return list;
	}

}
