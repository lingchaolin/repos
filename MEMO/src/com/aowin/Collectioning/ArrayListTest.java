package com.aowin.Collectioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * 	ArrayList
 * ����
 * �����ظ�
 * 
 * @author Administrator
 *����ͼ��ϵ�����
 *������Դ�Ż�����������Ҳ���Դ�Ŷ���--����ר��Ҳ�ܹ����Ŷ���
 *����Ҫ�����������ͣ����Ͽ��Դ���������
 *���鳤�ȹ̶���һ��ȷ�������޸ģ����ϳ��ȿ����Զ��ı�
 *
 *���ϵ����ͣ�List,Set,Map
 *Colection�ӿ��Ǽ��Ͽ����ϲ��һ���ӿڣ�������һЩ�����������������ӽӿ�
 *List:����-���ظ�
 *	ArrayList:-�ɱ�����--ʵ��List�ӿڵ��࣬�ײ�ʵ�ֵ��Ƕ�̬���飻
 *	LinkedList:-����--
 *	Vector:
 *Set
 */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		System.out.println(list.isEmpty());
		//���
		list.add("asd");
		list.add(0, null);
		list.add(2,123);//123Ϊint�ͣ��Զ�װ��ΪInteger��--������
		list.add("sfsef");
		list.add("234");
		list.add(2);
		list.add(12345.98);
		
		//������ϣ�
		System.out.println("list="+list);
		//ɾ��
		list.remove(2);//remove(Object obj)--ɾ���׸����ϵ�Ԫ��
		list.remove((Integer)2);//�Լ��Ӱ�����ת��
//		list.remove(new Integer(2));
		System.out.println("list="+list);
		
		
		//�޸�
		list.set(2, "hahaha");
		System.out.println("list="+list);
		//��ѯ
		System.out.println(list.get(2));
		
		//������ʽ
		System.out.println("foreach");
		for(Object obj:list) {
			System.out.print(obj+"    ");
		}
		System.out.println("forѭ��");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+"    ");
		}
		//����
		System.out.println("��������ʾ");
		Iterator it=list.iterator();//ע���������λ�ã�Iterator it֮��������ӣ�������ʱ������
		while(it.hasNext()) {//�ж��Ƿ�����һ��Ԫ��
			System.out.print(it.next()+"    ");//��������һ��Ԫ��
		}
	}

}
