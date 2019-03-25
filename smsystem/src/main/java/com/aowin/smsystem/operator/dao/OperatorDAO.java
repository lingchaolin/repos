/**
 * 
 */
package com.aowin.smsystem.operator.dao;

import java.util.List;
import java.util.Map;

import com.aowin.smsystem.operator.pojo.Operators;

/**����Ա����ģ��ҵ��ӿ�
 * @author Administrator
 *
 */
public interface OperatorDAO {
	/**
	 * ���Ӳ���Ա��
	 * @param o
	 * @return �Ƿ�ɹ�
	 * @throws Exception
	 */
	public int insertOperator(Operators o) throws Exception;
	/**
	 * ��ҳ��ʾ����Ա��Ϣ
	 * @param page ��ǰҳ
	 * @param pagesize ÿҳ��ʾ����
	 * @return ����Ա��Ϣ
	 */
	public List<Operators> getOperators(int page,int pagesize);
	//��������
	/**
	 * ��ȡ��ҳ��
	 * @param pagesize
	 * @return ��ҳ��
	 */
	public Integer getTotalPages(int pagesize);
	/**
	 * ����ָ����Ϣ��ȡ����Ա��Ϣ
	 * @param o ����Ա����Ϣ
	 * @return operators���ز���Ա��Ϣ
	 */
	public Operators getOperatorsById(Integer operatorid);
	/**
	 * �޸Ĳ���Ա��Ϣ 
	 * @param o ��������Ա��Ϣ
	 * @return �Ƿ��޸ĳɹ�
	 * @throws Exception
	 */
	public int updateOperators(Operators o)throws Exception;
	/**
	 * ���ݱ��ɾ������Ա
	 * @param operatorid ����Ա���
	 * @return �Ƿ�ɾ���ɹ�
	 * @throws Exception
	 */
	public int deleteOperator(Integer operatorid) throws Exception;
	/**
	 * ����ɾ������Ա
	 * @param no
	 * @return ɾ������Ա�ĸ���
	 * @throws Exception
	 */
	public int deleteOperators(List<Integer> operatorids) throws Exception;
	/**
	 * ϵͳ��¼��֤
	 * @param o�û���������
	 * @return Operators
	 */
	public Operators getoperatorbyusernameandpwd(Operators o);
}