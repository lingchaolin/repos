package com.aowin.forIO;

import java.io.*;

public class ByteFileBufferIO {
/**
 * ������--��װ��--��߶�дЧ��;����Ƶ�����ô�ͷ���𵽱������̵�����
 * @param args
 */
	public static void main(String[] args) {
		File file=new File("D:/Class/in2.txt");
//		FileBufferIOin(file);
		FileBufferIOin(file);
	}
	public static void FileBufferIOOut(File dest) {
		OutputStream os;
		try {
			os=new FileOutputStream(dest);
//			���������
			BufferedOutputStream bos=new BufferedOutputStream(os);
		
			bos.write(100);
			bos.write(100);
			bos.write("werw".getBytes());
			bos.flush();
			bos.close();
//			os.close();//ֵ�ر�bos���ɣ����عر�os
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void FileBufferIOin(File src) {
		InputStream is=null;
		 try {
			is=new FileInputStream(src);
			BufferedInputStream bis=new BufferedInputStream(is);
			
			byte car[]=new byte[1024];
			int len=0;
			StringBuilder sb=new StringBuilder();
			while(-1!=(len=bis.read())) {
				String info=new String(car,0,len);
				sb.append(info);
			}
			System.out.println(sb);
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
