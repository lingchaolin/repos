package com.aowin.junit;
/**
 * ���Է�����@test����
 * 
 * 
 * ����Ŀ¼�µİ��ṹ��Դ�ļ�Ŀ¼����һ��
 * ������������Test��β
 * ���Է�������test��ͷ
 * 
 * Failure-�����ڶ���ʧ�ܵ��µģ�������������н����һ�µ��µ�
 * Error-���ڲ��Դ���ͻ򱻲��Դ����е�bug���µ�
 *
 *
 *
 */
public class Two {

	public static void main(String[] args) {
		Two t=new Two();
		t.te();
		System.out.println("");
	}
	public void te() {
		for(int i=0;i<100;i++) {
			i++;
		}
	}
	public int add(int a,int b) {
		return a+b;
	}
	public int minus(int a,int b) {
		return a-b;
	}
	public int multiply(int a,int b) {
		return a*b;
	}
	public int div(int a,int b) {
		return a/b;
	}
}
