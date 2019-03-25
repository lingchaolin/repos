package com.aowin.Collectioning;
/**
 * 八种基本数据类型的包装类
 * byte		 	Byte
 * short	 	Short
 * int			Integer
 * long			Long
 * float		Float
 * double		Double
 * char			Character
 * booolean		Boolean
 * @author Administrator
 *
 */
public class PackClassTest {

	public static void main(String[] args) {
		int i=100;
		Integer j=new Integer(100);
		Integer k=new Integer(100);
		System.out.println(i==j);//j自动解包
		System.out.println(k==j);//j和k是不同的对象
	}

}
