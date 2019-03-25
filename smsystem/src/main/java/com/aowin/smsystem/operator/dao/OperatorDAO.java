/**
 * 
 */
package com.aowin.smsystem.operator.dao;

import java.util.List;
import java.util.Map;

import com.aowin.smsystem.operator.pojo.Operators;

/**操作员管理模块业务接口
 * @author Administrator
 *
 */
public interface OperatorDAO {
	/**
	 * 添加操作员呢
	 * @param o
	 * @return 是否成功
	 * @throws Exception
	 */
	public int insertOperator(Operators o) throws Exception;
	/**
	 * 分页显示操作员信息
	 * @param page 当前页
	 * @param pagesize 每页显示行数
	 * @return 操作员信息
	 */
	public List<Operators> getOperators(int page,int pagesize);
	//二级缓存
	/**
	 * 获取总页数
	 * @param pagesize
	 * @return 总页数
	 */
	public Integer getTotalPages(int pagesize);
	/**
	 * 根据指定信息获取操作员信息
	 * @param o 操作员的信息
	 * @return operators返回操作员信息
	 */
	public Operators getOperatorsById(Integer operatorid);
	/**
	 * 修改操作员信息 
	 * @param o 基本操作员信息
	 * @return 是否修改成功
	 * @throws Exception
	 */
	public int updateOperators(Operators o)throws Exception;
	/**
	 * 根据编号删除操作员
	 * @param operatorid 操作员编号
	 * @return 是否删除成功
	 * @throws Exception
	 */
	public int deleteOperator(Integer operatorid) throws Exception;
	/**
	 * 批量删除操作员
	 * @param no
	 * @return 删除操作员的个数
	 * @throws Exception
	 */
	public int deleteOperators(List<Integer> operatorids) throws Exception;
	/**
	 * 系统登录验证
	 * @param o用户名和密码
	 * @return Operators
	 */
	public Operators getoperatorbyusernameandpwd(Operators o);
}
