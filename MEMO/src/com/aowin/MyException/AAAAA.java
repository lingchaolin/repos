package com.aowin.MyException;

public class AAAAA {
/**�쳣��һ���࣬�̳���Throwable
 *  	�쳣�����ࣺ
 *  	1.Error:��Java��������ɲ��׳�������������
 *  	2.Exception:-Java������Ҫ����벶����������еķ�����ʱ�쳣��
 *  		2.1-RunTimeException:�������쳣��java����ɲ�����������ȱʡ���쳣�������
 * 		    2.2-�������쳣�����봦���粻����-����ͨ�����룻
 * 		���񲢴����쳣
 * 			finally����û�У�-finally�е����һ��Ҫ��ִ�У�
 * 			try{}catch(Exception e){	throw e}finally{}--���쳣�׳�Ҳ�Ǵ����쳣��һ�ַ�ʽ��
 * 		throws--�����쳣
 * 		throw--�׳��쳣--�����Զ����쳣
 */
/**�쳣������ŵ㣺
 * 		1.�Ѵ������ӳ�������з������
 * 		2.�Ѵ��󴫲������ö�ջ--(�쳣�Ĵ������쳣��������ջ�����ű����õ�˳����ǰѰ�ң�ֻҪ�ҵ����ϸ��쳣������쳣������򣬾ͽ����ⲿ�ֳ���ȥ����)
 * 		3.�Ѵ������ͺʹ�������飻
 * 
 * 		4.ϵͳ�ṩ��һЩ���޷�Ԥ��Ĵ���Ĳ���ʹ���
 * 		5.�˷��˴�ͳ�����Ĵ�����Ϣ���޵����⣻
 */
/**�����Լ����쳣--����̳�Throwable��Exception;--����ʹ��Exception;
 * 
*public class MyException  extends Exception{
		public  MyException(){
			super("�Զ���MyException!");--ָ���������
		}
		public  MyException(String str){
			super(str);
		}
	}
 * 	
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
