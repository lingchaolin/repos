package com.aowin.regx;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式-灵活高效，功能强大
 * @author Administrator
 *普通字符和元字符
 */
public class One {

	public static void main(String[] args) {
/*	关于字符数量的规定
		 +	一个以上
		 *任意数量
		 ?0或1个
		{m,n}表达式至少重复m次，最多重复n次；
		{m,}最少m次
		 {n}表达式恰好n次
*/		
		String reg="java";
		String str="java";
//		System.out.println("reg="+reg);
			if(str.matches(reg)) {
				System.err.println("字符串:"+str+"--regex:"+reg+"--"+str.matches(reg));
			}else {
				System.out.println("字符串:"+str+"--regex:"+reg+"--"+str.matches(reg));
			}
			
			reg="^1\\d+4$";//匹配数字-多个
			str="123124";
				if(str.matches(reg)) {
					System.err.println("字符串:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}else {
					System.out.println("字符串:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}
				
			reg="[f-s]{2,}";//匹配字母--至少2次
			str="fsf";
				if(str.matches(reg)) {
					System.err.println("字符串:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}else {
					System.out.println("字符串:"+str+"--regex:"+reg+"--"+str.matches(reg));
				}
			
//		对于特殊字符*+?\.等，要使用字符本身使用转义字符；
//		除'^'和'-'外的符号被[]包围后失去特殊意义
//		^用来取反，-用来连接范围
		reg="[+]";
		str="2q+-2+q-4q+4-q+5";
		String arr[]=str.split(reg);
		for(String a:arr) {
			System.out.println(a);
		}
		
//		分组用()表示--匹配ip地址（xxx.xxx.xxx.xxx	1-3位数字）
		reg="([12]?\\d{1,}\\.){3}([12]?\\d{1,})";
		str="192.168.2.1";
		str.matches(reg);
		System.out.println(str.matches(reg));
//		从大量文本中找出感兴趣的部分
//		用模式匹配给定的内容
		reg="[Hh]ello";
		str="rgegrrrgerhellogrergrgHelloddrgrg";
//		将给定的正则表达式编译到具有给定标志的模式中。
		Pattern p=Pattern.compile(reg);//正则表达式的编译表示形式。
//		创建匹配给定输入与此模式的匹配器。
		Matcher mat=p.matcher(str);
		while(mat.find()) {//如果有下一个--尝试查找与该模式匹配的输入序列的下一个子序列。
			int start=mat.start();//起始位置-- 返回以前匹配的初始索引。
			int end=mat.end();//结束位置--返回最后匹配字符之后的偏移量。
			String text=mat.group(); //返回由以前匹配操作所匹配的输入子序列。
			System.out.println("从"+start+"到"+end+"之间找到了"+text);
		}
		
		reg="([Hh]e[a-x]llo)|(d[io]g)";
		str="rgegrdogrrgerhebllogrergrgHemlloddrgrdigg";
//		将给定的正则表达式编译到具有给定标志的模式中。
		p=Pattern.compile(reg);//正则表达式的编译表示形式。
//		创建匹配给定输入与此模式的匹配器。
		mat=p.matcher(str);
		while(mat.find()) {//如果有下一个--尝试查找与该模式匹配的输入序列的下一个子序列。
			int start=mat.start();//起始位置-- 返回以前匹配的初始索引。
			int end=mat.end();//结束位置--返回最后匹配字符之后的偏移量。
//			.group(int)是从 1 开始从左到右的索引。组零表示整个模式，因此表达式 m.group(0) 等效于 m.group()。 
			String text=mat.group(1); //返回由以前匹配操作所匹配的输入子序列。
			System.out.println("从"+start+"到"+end+"之间找到了"+text);
		}
//		^约束起始，$约束结尾；--指的是整个文本
	}

}
