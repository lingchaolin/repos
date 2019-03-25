package com.aowin.proxy;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Client {
	public static void main(String[] args) throws Exception{
		String srcStr="D:\\test.txt";
		String destStr="D:\\test2.txt";
		Client client=new Client();
//		client.copyFile(srcStr, destStr);
//		client.read(srcStr);
//		client.write(destStr);
//		client.FileInSigle(new File(srcStr));
		client.dataOut(destStr);
		client.dataIn(destStr);
	}
	public void copyFile(String  srcStr,String destStr) throws Exception{
		InputStream is=new FileInputStream(new File(srcStr));
		OutputStream os=new FileOutputStream(new File(destStr));
		
		byte[]arr =new byte[1024];
		int len=-1;
		while(-1!=(len=is.read(arr))) {
			os.write(arr, 0, arr.length);
		}
		os.flush();
		os.close();
		is.close();
	}
	public void read(String srcStr) throws Exception {
		InputStream is=new FileInputStream(new File(srcStr));
		byte[]arr=new byte[1024];
		int len=-1;
		StringBuffer sb=new StringBuffer();
		while(-1!=(len=is.read(arr))) {
			String string=new String(arr,0,len ,"UTF-8");
			System.out.println(len);
			sb.append(string);
		}
		System.out.println(sb);
		is.close();
	}
	public void write(String destStr) throws Exception {
		OutputStream os=new FileOutputStream(new File(destStr));
		byte arr[]="≤‚ ‘≤‚ ‘£°£°≤‚ ‘".getBytes("GBK");
		os.write(arr,0,arr.length);
		os.flush();
		os.close();
		System.out.println("writeΩ· ¯");
	}
    public static void FileInSigle(File file) {
        InputStream iis=null;
        try {
              iis=new FileInputStream(file);
              int i=-1;
              while(-1!=(i=iis.read())) {
                    System.out.println((char)i);
              }
        } catch (Exception e) {
              e.printStackTrace();
        }
  }
    public void dataOut(String destStr) throws Exception {
    	DataOutputStream dos=new DataOutputStream(
    			new FileOutputStream(new File(destStr)));
    	dos.writeUTF("123test");
    	dos.writeInt(123);
    	dos.flush();
    	System.out.println("outFinish");
    }
    public void dataIn(String srcStr) throws Exception{
    	DataInputStream dis=new DataInputStream(
    			new FileInputStream(new File(srcStr)));
    	String string=dis.readUTF();
    	int num=dis.readInt();
    	System.out.println(string);
    	System.out.println(num);
    }
}
