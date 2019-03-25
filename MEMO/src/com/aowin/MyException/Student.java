package com.aowin.MyException;

import java.util.Scanner;


/**
 * 4.通过类和类继承，定义学生基本信息（学号、姓名、性别、年龄），然后定义学生成绩类（定义为基本信息类的子类），
 * 包括课程门数，每门课程的成绩（用一维数组表示）、课程名称（用String类型一维数组表示）。
 * 使用学生基本信息类和成绩信息类可实现学生基本信息输入、成绩输入、学生人数和课程门数由输入决定。
 * 能完成学生成绩表输出（含每门课程成绩，总平均成绩）
 * @author Administrator
 *
 *学生基本信息{（学号、姓名、性别、年龄）}---学生基本信息输入（学号、姓名、性别、年龄）--学生人数
 *学生成绩类(子类){ score类{}}
 */
public class Student {
	static double []total;
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入学生人数");
		int stu_num=scan.nextInt();//学生人数
		System.out.println("请输入课程门数");
		int sub_num=scan.nextInt();//课程数
		while(sub_num>10) {
			System.out.println("课程数不大于十，请重新输入！");
			sub_num=scan.nextInt();
		}
//		int stu_num=2;
//		int sub_num=1;
		
		Manage ma=new Manage(stu_num,sub_num);
		System.out.println("请输入学生基本信息：");
		int no = 0;
		String name=null;
		String sex=null;
		double temp[]=new double[sub_num];
		total=new double[sub_num];
		int age=0;
//		ma.stus[0]=new StuScore(101,"Hinata","女",14,sub_num);
//		ma.stus[1]=new StuScore(102,"Sakula","女",15,sub_num);
		for(int i=0;i<stu_num;i++) {
			System.out.print("请输入学号:(int)");
			no=scan.nextInt();
			System.out.print("请输入姓名:(String)");
			name=scan.next();
			System.out.print("请输入性别:(String)");
			sex=scan.next();
			System.out.print("请输入年龄:(int)");
			age=scan.nextInt();
			ma.stus[i]=new StuScore(no,name,sex,age,sub_num);
			System.out.println("请输入该学生的成绩：");
			for(int j=0;j<sub_num;j++) {
				System.out.print(ma.stus[i].subjects[j]+":");
				ma.stus[i].scores[j]=scan.nextDouble();
				temp[j]=ma.stus[i].scores[j];
				total[j]+=ma.stus[i].scores[j];
			}
				switch(sub_num){
				case 5:
					ma.stus[i].SetSub(temp[0],temp[1],temp[2],temp[3],temp[4]);
					break;
				case 4:
					ma.stus[i].SetSub(temp[0],temp[1],temp[2],temp[3]);			
					break;
				case 3:
					ma.stus[i].SetSub(temp[0],temp[1],temp[2],temp[3]);			
					break;
				case 2:
					ma.stus[i].SetSub(temp[0],temp[1]);
					break;
				case 1:
					ma.stus[i].SetSub(temp[0]);
					break;
				default :
					break;
			}
		}
		
		ma.printMessage();
	}
}
class Manage{
	StuScore stus[];
	int stu_num;
	int sub_num;
	
	public Manage(int stu_num,int sub_num) {
		stus=new StuScore[stu_num];
		this.stu_num=stu_num;
		this.sub_num=sub_num;
	}
	//获得学生基本信息
	public void showBaseMessage(StuScore stu) {
		System.out.print("学号:"+stu.no+",姓名:"+stu.name+",性别:"+stu.sex+",年龄:"+stu.age);
	}
	//打印学生基本信息
	public void printMessage() {
		System.out.println("成绩单：");
		for(int j=0;j<sub_num;j++) {
			System.out.println(stus[0].subjects[j]+"总分为:"+Student.total[j]+" ,平均分为:"+(Student.total[j]/stu_num));
		}
		for(int i=0;i<stu_num;i++) {
			if(null!=stus[i]) {
				showBaseMessage(stus[i]);
				printScore(stus[i]);
				System.out.println();
			}
		}
	}
	public void printScore(StuScore stu) {
		for(int j=0;j<sub_num;j++) {
			System.out.print(" "+stu.subjects[j]+":"+stu.scores[j]+" ");
		}
	}
}
class StuScore extends StuMessage{
	StuScore stus[];	
	String subjects[];
	double scores[];
	int sub_num;
	
	
	public StuScore(int no, String name, String sex, int age,int sub_num) {
		super( no,name,sex,age);
		this.sub_num=sub_num;
		subjects=new String[sub_num];
		scores=new double[sub_num];
		switch(sub_num){
			case 10:
				subjects[9]=new String("体育");
			case 9:
				subjects[8]=new String("生物");
			case 8:
				subjects[7]=new String("地理");
			case 7:
				subjects[6]=new String("化学");
			case 6:
				subjects[5]=new String("物理");
			case 5:
				subjects[4]=new String("政治");
			case 4:
				subjects[3]=new String("历史");
			case 3:
				subjects[2]=new String("英语");
			case 2:
				subjects[1]=new String("数学");
			case 1:
				subjects[0]=new String("语文");
		}
	}
	public void SetSub(double ...sco ){
		for(int j=0;j<sco.length;j++) {
			scores[j]=sco[j];
		}
	}
	
}
class StuMessage{
	int no;
	String name;
	String sex;
	int age;
	
	public StuMessage() {}
	public StuMessage(int no, String name, String sex, int age) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
		
	}
	
}