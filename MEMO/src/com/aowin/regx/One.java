package com.aowin.regx;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������ʽ-����Ч������ǿ��
 * @author Administrator
 *��ͨ�ַ���Ԫ�ַ�
 */
public class One {

	public static void main(String[] args) {
/*	�����ַ������Ĺ涨
		 +	һ������
		 *��������
		 ?0��1��
		{m,n}���ʽ�����ظ�m�Σ�����ظ�n�Σ�
		{m,}����m��
		 {n}���ʽǡ��n��
*/		
		String reg="java";
		String str="java";
//		System.out.println("reg="+reg);
			if(str.matches(reg)) {
				System.err.println("�ַ���:"+str+"--regex:"+reg+"--"+str.matches(reg));
			}else {
				System.out.println("�ַ���:"+str+"--regex:"+reg+"--"+str.matches(reg));
			}
			
			reg="^1\\d+4$";//ƥ������-���
			str="123124";
				if(str.matches(reg)) {
					System.err.println("�ַ���:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}else {
					System.out.println("�ַ���:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}
				
			reg="[f-s]{2,}";//ƥ����ĸ--����2��
			str="fsf";
				if(str.matches(reg)) {
					System.err.println("�ַ���:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}else {
					System.out.println("�ַ���:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}
			
//		���������ַ�*+?\.�ȣ�Ҫʹ���ַ�����ʹ��ת���ַ���
//		��'^'��'-'��ķ��ű�[]��Χ��ʧȥ��������
//		^����ȡ����-�������ӷ�Χ
		reg="[+]";
		str="2q+-2+q-4q+4-q+5";
		String arr[]=str.split(reg);
		for(String a:arr) {
			System.out.println(a);
		}
		
//		������()��ʾ--ƥ��ip��ַ��xxx.xxx.xxx.xxx	1-3λ���֣�
		reg="([12]?\\d{1,}\\.){3}([12]?\\d{1,})";
		str="192.168.2.1";
		str.matches(reg);
		System.out.println(str.matches(reg));
//		�Ӵ����ı����ҳ�����Ȥ�Ĳ���
//		��ģʽƥ�����������
		reg="[Hh]ello";
		str="rgegrrrgerhellogrergrgHelloddrgrg";
//		��������������ʽ���뵽���и�����־��ģʽ�С�
		Pattern p=Pattern.compile(reg);//������ʽ�ı����ʾ��ʽ��
//		����ƥ������������ģʽ��ƥ������
		Matcher mat=p.matcher(str);
		while(mat.find()) {//�������һ��--���Բ������ģʽƥ����������е���һ�������С�
			int start=mat.start();//��ʼλ��-- ������ǰƥ��ĳ�ʼ������
			int end=mat.end();//����λ��--�������ƥ���ַ�֮���ƫ������
			String text=mat.group(); //��������ǰƥ�������ƥ������������С�
			System.out.println("��"+start+"��"+end+"֮���ҵ���"+text);
		}
		
		reg="([Hh]e[a-x]llo)|(d[io]g)";
		str="rgegrdogrrgerhebllogrergrgHemlloddrgrdigg";
//		��������������ʽ���뵽���и�����־��ģʽ�С�
		p=Pattern.compile(reg);//������ʽ�ı����ʾ��ʽ��
//		����ƥ������������ģʽ��ƥ������
		mat=p.matcher(str);
		while(mat.find()) {//�������һ��--���Բ������ģʽƥ����������е���һ�������С�
			int start=mat.start();//��ʼλ��-- ������ǰƥ��ĳ�ʼ������
			int end=mat.end();//����λ��--�������ƥ���ַ�֮���ƫ������
//			.group(int)�Ǵ� 1 ��ʼ�����ҵ������������ʾ����ģʽ����˱��ʽ m.group(0) ��Ч�� m.group()�� 
			String text=mat.group(1); //��������ǰƥ�������ƥ������������С�
			System.out.println("��"+start+"��"+end+"֮���ҵ���"+text);
		}
//		^Լ����ʼ��$Լ����β��--ָ���������ı�
	}

}
