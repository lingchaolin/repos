package com.aowin.MyException;

public class AAAAA {
/**异常是一个类，继承自Throwable
 *  	异常分三类：
 *  	1.Error:由Java虚拟机生成并抛出，程序不做处理
 *  	2.Exception:-Java编译器要求必须捕获或声明所有的非运行时异常；
 *  		2.1-RunTimeException:运行期异常，java程序可不做处理，交给缺省的异常处理程序
 * 		    2.2-编译期异常：必须处理，如不处理-不能通过编译；
 * 		捕获并处理异常
 * 			finally可以没有，-finally中的语句一定要被执行；
 * 			try{}catch(Exception e){	throw e}finally{}--将异常抛出也是处理异常的一种方式；
 * 		throws--声明异常
 * 		throw--抛出异常--可以自定义异常
 */
/**异常处理的优点：
 * 		1.把错误代码从常规代码中分离出来
 * 		2.把错误传播给调用堆栈--(异常的传播：异常传播给堆栈后，沿着被调用的顺序往前寻找，只要找到符合该异常种类的异常处理程序，就交给这部分程序去处理；)
 * 		3.把错误类型和错误差别分组；
 * 
 * 		4.系统提供了一些对无法预测的错误的捕获和处理
 * 		5.克服了传统方法的错误信息有限的问题；
 */
/**创建自己的异常--必须继承Throwable或Exception;--建议使用Exception;
 * 
*public class MyException  extends Exception{
		public  MyException(){
			super("自定义MyException!");--指定输出内容
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
