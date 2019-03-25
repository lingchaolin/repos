package com.aowin.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.aowin.dao.TuserMapper;
import com.aowin.model.Person;
import com.aowin.util.DbUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Test {
	public static void main(String[] args) {
		SqlSession session=DbUtil.openSession();
		TuserMapper mapper=session.getMapper(TuserMapper.class);
		try {
			//������ͨ�����ӷ�����
			Person person=new Person(234,"�����",1,"leder",2222);
			/*int n=mapper.insertUser(person);
			session.commit();
			System.out.println("Ӱ����������"+n);*/
			
			//ģ����ѯ&Map��ֵ��ѯ
			/*Map<String, Object> map=new HashMap<>();
			map.put("id", 101);
			map.put("salary",1);
			map.put("tablename","person");
			ArrayList<Person> perList= mapper.selectLikeUser(map);
			System.out.println(Arrays.toString(perList.toArray()));*/
			
			//param����
		/*	ArrayList<Person> list = mapper.selectUser(101,"�����");
			System.out.println(Arrays.toString(list.toArray()));*/
			/*#{}
			  ${} �滻�ַ���,������Ϊ��������ע���Σ��
			  concat(#{name},'%');ƴ���ַ���
			 */
			
			//where����
			/*Map<String, Object> map=new HashMap<>();
			map.put("id", 102);
			map.put("tablename","person");
			ArrayList<Person> perList= mapper.selectWhereUser(map);
			System.out.println(Arrays.toString(perList.toArray()));*/
			
			//choose��֧���
			/*Map<String, Object> map=new HashMap<>();
			map.put("type",2);
			ArrayList<Person> perList= mapper.selectChooseUser(map);
			System.out.println(Arrays.toString(perList.toArray()));*/
			
			//�޸�
		/*	Map<String, Object> map=new HashMap<>();
			map.put("id", 101);
			map.put("rename","����");
			map.put("resex","1");
			int n=mapper.updateUser(map);
			session.commit();
			System.out.println("�޸ĳɹ���"+n);*/
			
			/*����ɾ��*/
		/*	ArrayList<Integer> list=new ArrayList<>();
			list.add(233);
			list.add(234);
			mapper.deleteUser(list);
			session.commit();*/
			//��������
			/*ArrayList<Person> list=new ArrayList<>();
			list.add(new Person(203, "����", 1, "lead", 101010));
			list.add(new Person(204, "������", 9, "lead", 101010));
			mapper.batchInsert(list);
			session.commit();*/
			//ӳ�� 
		/*	ArrayList<Person> list=mapper.selectUriUser();
			System.out.println(Arrays.toString(list.toArray()));*/
			
			
			//5.��ҳ��ѯ--Ҫ��mybatis�����ò��
			/*PageHelper.startPage(2, 2);//��ʼ��ҳ ��һ�������ǵ�ǰҳ�� �ڶ�������ÿҳ��ʾ����������
			Map<String, Object> map = new HashMap<>();
			map.put("tablename","person");
			ArrayList<Person> list = mapper.selectWhereUser(map);
			//��ҳ����
			PageInfo<Person> info = new PageInfo<>(list);
			System.out.println("info:"+info.getList());
			System.out.println(info.getPageSize());
			System.out.println(info.getPageNum());*/
			
			
			//ӳ��  resultMap
			ArrayList<Person> list=mapper.selectResultMap(111);
			System.out.println(Arrays.toString(list.toArray()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(session);
		}
	}
}

