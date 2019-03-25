package com.aowin.review.rtti;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetContentPicture {
public void getHtmlPicture(String httpUrl) {
URL url;
BufferedInputStream in;
FileOutputStream file;
try {
  System.out.println("ȡ����ͼƬ");
  String fileName = httpUrl.substring(httpUrl.lastIndexOf("/"));
  String filePath = "./pic/";
  url = new URL(httpUrl);

  in = new BufferedInputStream(url.openStream());

  file = new FileOutputStream(new File(filePath+fileName));
  int t;
  while ((t = in.read()) != -1) {
  file.write(t);
  }
  file.close();
  in.close();
  System.out.println("ͼƬ��ȡ�ɹ�");
} catch (MalformedURLException e) {
  e.printStackTrace();
} catch (FileNotFoundException e) {
  e.printStackTrace();
} catch (IOException e) {
  e.printStackTrace();
}
}

public String getHtmlCode(String httpUrl) throws IOException {
String content ="";
URL uu = new URL(httpUrl); // ����URL�����
BufferedReader ii = new BufferedReader(new InputStreamReader(uu
  .openStream())); // //ʹ��openStream�õ�һ���������ɴ˹���һ��BufferedReader����
String input;
while ((input = ii.readLine()) != null) { // ������ȡѭ�������ж��Ƿ��ж�ȡֵ
  content += input;
}
ii.close();
return content;
}

public void get(String url) throws IOException {

String searchImgReg = "(?x)(src|SRC|background|BACKGROUND)=('|\")/?(([\\w-]+/)*([\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";
String searchImgReg2 = "(?x)(src|SRC|background|BACKGROUND)=('|\")(http://([\\w-]+\\.)+[\\w-]+(:[0-9]+)*(/[\\w-]+)*(/[\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";

String content = this.getHtmlCode(url);
System.out.println(content);

Pattern pattern = Pattern.compile(searchImgReg);
Matcher matcher = pattern.matcher(content);
while (matcher.find()) {
  System.out.println(matcher.group(3));
  this.getHtmlPicture(url+matcher.group(3));

}

pattern = Pattern.compile(searchImgReg2);
matcher = pattern.matcher(content);
while (matcher.find()) {
  System.out.println(matcher.group(3));
  this.getHtmlPicture(matcher.group(3));

}
// searchImgReg =
// "(?x)(src|SRC|background|BACKGROUND)=('|\")/?(([\\w-]+/)*([\\w-]+\\.(jpg|JPG|png|PNG|gif|GIF)))('|\")";
}
public static void main(String[] args) throws IOException {
String url = "http://www.baidu.com/";
GetContentPicture gcp = new GetContentPicture();
gcp.get(url);
}
}