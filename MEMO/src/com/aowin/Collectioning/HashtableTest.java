package com.aowin.Collectioning;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {
/**��ֵ��
 * ����ֵ����Ϊnull;
 * ����ֵ��ͬ��valueֱֵ�Ӹ��ǣ�
 * ֵ������ͬ���������ظ�
 * --ͬ��
 * @param args
 */
	public static void main(String[] args) {
		Hashtable<Integer, String> ht=new Hashtable<Integer, String>();
		ht.put(101, "hinata");
		ht.put(103, "naruto");
		ht.put(102, "Saber");
		System.out.println(ht);
		//���ؼ���Ӧ��ֵ����������--����null;s
		ht.remove(103);
		System.out.println(ht);
//		4.����
		Set<Integer> keys=ht.keySet();
		Iterator<Integer> it=keys.iterator();
	}

}
