package com.aowin.Collectioning;
/**
 * ���ֻ����������͵İ�װ��
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
		System.out.println(i==j);//j�Զ����
		System.out.println(k==j);//j��k�ǲ�ͬ�Ķ���
	}

}
