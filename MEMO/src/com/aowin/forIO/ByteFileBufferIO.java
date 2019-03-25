package com.aowin.forIO;

import java.io.*;

public class ByteFileBufferIO {
/**
 * 缓冲流--包装流--提高读写效率;避免频繁调用磁头，起到保护磁盘的作用
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
//			缓冲输出流
			BufferedOutputStream bos=new BufferedOutputStream(os);
		
			bos.write(100);
			bos.write(100);
			bos.write("werw".getBytes());
			bos.flush();
			bos.close();
//			os.close();//值关闭bos即可，不必关闭os
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
