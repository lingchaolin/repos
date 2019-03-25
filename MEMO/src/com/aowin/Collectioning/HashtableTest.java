package com.aowin.Collectioning;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {
/**键值对
 * 键、值不能为null;
 * 若键值相同，value值直接覆盖；
 * 值可以相同，键不能重复
 * --同步
 * @param args
 */
	public static void main(String[] args) {
		Hashtable<Integer, String> ht=new Hashtable<Integer, String>();
		ht.put(101, "hinata");
		ht.put(103, "naruto");
		ht.put(102, "Saber");
		System.out.println(ht);
		//返回键对应的值，若不存在--返回null;s
		ht.remove(103);
		System.out.println(ht);
//		4.遍历
		Set<Integer> keys=ht.keySet();
		Iterator<Integer> it=keys.iterator();
	}

}
