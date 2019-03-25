package com.aowin.javabasic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class CopyVideo {
	public CopyVideo() {

	}
	public static void main(String[] args) throws Exception {
		String url="http://issc.isoftstone.com/Common/Videos/b_clip.mp4-%3Evideo/mp4";
		String name="b_clip.mp4";
//		getVideo(url, name);
		getVideo2(url);
		System.out.println("Ω· ¯");
	}
	public static void getVideo(String url,String name)  {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO“Ï≥£");
		}
	}
	public static void getVideo2(String urlStr)  {
		InputStream is;
		FileOutputStream fos;
		BufferedInputStream bis;
		BufferedOutputStream bos = null;
		try {
			URL url=new URL(urlStr);
			URLConnection urlConnection=url.openConnection();
			is=urlConnection.getInputStream();
			fos=new FileOutputStream("E:/ftp/123.mp4");
			bis=new BufferedInputStream(is);
			byte[]b=new byte[1024];
			int count;
			while((count=bis.read(b,0,b.length))!=-1) {
				bos.write(b,0,count);
			}
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO“Ï≥£");
		}
	}
}
