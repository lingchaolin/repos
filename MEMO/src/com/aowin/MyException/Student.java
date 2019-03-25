package com.aowin.MyException;

import java.util.Scanner;


/**
 * 4.ͨ�������̳У�����ѧ��������Ϣ��ѧ�š��������Ա����䣩��Ȼ����ѧ���ɼ��ࣨ����Ϊ������Ϣ������ࣩ��
 * �����γ�������ÿ�ſγ̵ĳɼ�����һά�����ʾ�����γ����ƣ���String����һά�����ʾ����
 * ʹ��ѧ��������Ϣ��ͳɼ���Ϣ���ʵ��ѧ��������Ϣ���롢�ɼ����롢ѧ�������Ϳγ����������������
 * �����ѧ���ɼ����������ÿ�ſγ̳ɼ�����ƽ���ɼ���
 * @author Administrator
 *
 *ѧ��������Ϣ{��ѧ�š��������Ա����䣩}---ѧ��������Ϣ���루ѧ�š��������Ա����䣩--ѧ������
 *ѧ���ɼ���(����){ score��{}}
 */
public class Student {
	static double []total;
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("������ѧ������");
		int stu_num=scan.nextInt();//ѧ������
		System.out.println("������γ�����");
		int sub_num=scan.nextInt();//�γ���
		while(sub_num>10) {
			System.out.println("�γ���������ʮ�����������룡");
			sub_num=scan.nextInt();
		}
//		int stu_num=2;
//		int sub_num=1;
		
		Manage ma=new Manage(stu_num,sub_num);
		System.out.println("������ѧ��������Ϣ��");
		int no = 0;
		String name=null;
		String sex=null;
		double temp[]=new double[sub_num];
		total=new double[sub_num];
		int age=0;
//		ma.stus[0]=new StuScore(101,"Hinata","Ů",14,sub_num);
//		ma.stus[1]=new StuScore(102,"Sakula","Ů",15,sub_num);
		for(int i=0;i<stu_num;i++) {
			System.out.print("������ѧ��:(int)");
			no=scan.nextInt();
			System.out.print("����������:(String)");
			name=scan.next();
			System.out.print("�������Ա�:(String)");
			sex=scan.next();
			System.out.print("����������:(int)");
			age=scan.nextInt();
			ma.stus[i]=new StuScore(no,name,sex,age,sub_num);
			System.out.println("�������ѧ���ĳɼ���");
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
	//���ѧ��������Ϣ
	public void showBaseMessage(StuScore stu) {
		System.out.print("ѧ��:"+stu.no+",����:"+stu.name+",�Ա�:"+stu.sex+",����:"+stu.age);
	}
	//��ӡѧ��������Ϣ
	public void printMessage() {
		System.out.println("�ɼ�����");
		for(int j=0;j<sub_num;j++) {
			System.out.println(stus[0].subjects[j]+"�ܷ�Ϊ:"+Student.total[j]+" ,ƽ����Ϊ:"+(Student.total[j]/stu_num));
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
				subjects[9]=new String("����");
			case 9:
				subjects[8]=new String("����");
			case 8:
				subjects[7]=new String("����");
			case 7:
				subjects[6]=new String("��ѧ");
			case 6:
				subjects[5]=new String("����");
			case 5:
				subjects[4]=new String("����");
			case 4:
				subjects[3]=new String("��ʷ");
			case 3:
				subjects[2]=new String("Ӣ��");
			case 2:
				subjects[1]=new String("��ѧ");
			case 1:
				subjects[0]=new String("����");
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