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
			//调用普通的增加方法：
			Person person=new Person(234,"刘亦菲",1,"leder",2222);
			/*int n=mapper.insertUser(person);
			session.commit();
			System.out.println("影响数据量："+n);*/
			
			//模糊查询&Map传值查询
			/*Map<String, Object> map=new HashMap<>();
			map.put("id", 101);
			map.put("salary",1);
			map.put("tablename","person");
			ArrayList<Person> perList= mapper.selectLikeUser(map);
			System.out.println(Arrays.toString(perList.toArray()));*/
			
			//param传参
		/*	ArrayList<Person> list = mapper.selectUser(101,"刘亦菲");
			System.out.println(Arrays.toString(list.toArray()));*/
			/*#{}
			  ${} 替换字符串,可以作为表名，有注入的危险
			  concat(#{name},'%');拼接字符串
			 */
			
			//where条件
			/*Map<String, Object> map=new HashMap<>();
			map.put("id", 102);
			map.put("tablename","person");
			ArrayList<Person> perList= mapper.selectWhereUser(map);
			System.out.println(Arrays.toString(perList.toArray()));*/
			
			//choose分支语句
			/*Map<String, Object> map=new HashMap<>();
			map.put("type",2);
			ArrayList<Person> perList= mapper.selectChooseUser(map);
			System.out.println(Arrays.toString(perList.toArray()));*/
			
			//修改
		/*	Map<String, Object> map=new HashMap<>();
			map.put("id", 101);
			map.put("rename","张三");
			map.put("resex","1");
			int n=mapper.updateUser(map);
			session.commit();
			System.out.println("修改成功："+n);*/
			
			/*批量删除*/
		/*	ArrayList<Integer> list=new ArrayList<>();
			list.add(233);
			list.add(234);
			mapper.deleteUser(list);
			session.commit();*/
			//批量新增
			/*ArrayList<Person> list=new ArrayList<>();
			list.add(new Person(203, "华融", 1, "lead", 101010));
			list.add(new Person(204, "哈骄傲", 9, "lead", 101010));
			mapper.batchInsert(list);
			session.commit();*/
			//映射 
		/*	ArrayList<Person> list=mapper.selectUriUser();
			System.out.println(Arrays.toString(list.toArray()));*/
			
			
			//5.分页查询--要在mybatis中配置插件
			/*PageHelper.startPage(2, 2);//开始分页 第一个参数是当前页面 第二个参数每页显示多少条数据
			Map<String, Object> map = new HashMap<>();
			map.put("tablename","person");
			ArrayList<Person> list = mapper.selectWhereUser(map);
			//分页数据
			PageInfo<Person> info = new PageInfo<>(list);
			System.out.println("info:"+info.getList());
			System.out.println(info.getPageSize());
			System.out.println(info.getPageNum());*/
			
			
			//映射  resultMap
			ArrayList<Person> list=mapper.selectResultMap(111);
			System.out.println(Arrays.toString(list.toArray()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(session);
		}
	}
}

