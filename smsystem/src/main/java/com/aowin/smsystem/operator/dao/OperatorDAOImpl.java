/**
 * 
 */
package com.aowin.smsystem.operator.dao;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.aowin.smsystem.operator.pojo.Operators;


/**����Ա����ģ��ҵ���߼�ʵ����
 * @author Administrator
 *
 */
@Transactional
public class OperatorDAOImpl implements OperatorDAO{
	/*��־������   ����-Ŀ�ĵ�-�������ʽ*/
	//������־����
	Logger log=LogManager.getLogger();
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public OperatorDAOImpl() {
		
	}
	@Override
	public int insertOperator(Operators o) throws Exception {
		return sqlSessionTemplate.insert("insertOperator",o);
	}
	@Override
	@Transactional(readOnly=true)
	public List<Operators> getOperators(int pages, int pagesize) {
		return sqlSessionTemplate.selectList("getOperators",null,new RowBounds((pages-1)*pagesize,pagesize));
	}
	@Override
	@Transactional(readOnly=true)
	public Integer getTotalPages(int pagesize) {
		log.info("����ҵ���߼�����:getTotalPages(int pagesize)");
		Integer totalpages = 0;
		Integer totalrecords = sqlSessionTemplate.selectOne("gettotalrecords");
		totalpages = (totalrecords%pagesize==0?0:1) + totalrecords/pagesize;
		if(totalpages == 0) {
			totalpages = 1;
		}
		return totalpages;
	}
/*	@Override
	public List<Operators> getAllOperators() {
		return sqlSessionTemplate.selectList("getAllOperators");
	}
	@Override
	public Integer gettotalrecords() {
		return null;
	}*/
	@Override
	@Transactional(readOnly=true)
	public Operators getOperatorsById(Integer operatorid) {
		return sqlSessionTemplate.selectOne("getOperatorsById", operatorid);
	}
	@Override
	public int updateOperators(Operators o) throws Exception {
		return sqlSessionTemplate.update("updateOperators", o);
	}
	@Override
	public int deleteOperator(Integer operatorid) throws Exception {
		return sqlSessionTemplate.delete("deleteOperator", operatorid);
	}
	@Override
	public int deleteOperators(List<Integer> operatorids) throws Exception {
		return sqlSessionTemplate.delete("deleteOperators", operatorids);
	}
	@Override
	public Operators getoperatorbyusernameandpwd(Operators o) {
		return sqlSessionTemplate.selectOne("getoperatorbyusernameandpwd", o);
	}

}