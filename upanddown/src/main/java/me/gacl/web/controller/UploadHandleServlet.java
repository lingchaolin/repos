package me.gacl.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadHandleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//     ��ȡԴ��ַ
//    	�Ƿ���ȷ
    	
//    	��ȡĿ���ַ--�ַ���ת����Ŀ¼
    	String savePath=this.getServletContext().getRealPath("/WEB-INF/upload");
    	System.out.println();
    	File file=new File(savePath);
//    	�Ƿ���ȷ
    	if(!file.exists()&&!file.isDirectory()) {
    		System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ������");
    		file.mkdirs();
    	}
    	String message="";
    	try {
	//    	ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
	//    	1.����һ��DiskFileItemFactory����
	    		DiskFileItemFactory factory=new DiskFileItemFactory();
	//    	2.�����ϴ��ļ��Ľ�����
	    		ServletFileUpload fileUpload=new ServletFileUpload(factory);
	    		fileUpload.setHeaderEncoding("UTF-8");
	//    	3.�ж��ύ�����������Ƿ����ϴ���������
	    		if(!ServletFileUpload.isMultipartContent(request)) {//�ж��Ƿ�����ಿ�ֵ����ݣ�������������ϴ����ļ���
	    			return;
	    		}
	//    	4.�����ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem>list=fileUpload.parseRequest(request);
			for(FileItem item:list) {
				//���fileitem�з�װ������ͨ�����������
//				�ж�ĳ���Ƿ�����ͨ�ı����͡�
				if(item.isFormField()) {
					String name=item.getFieldName();
					String value=item.getString("UTF-8");
					System.out.println(name+"="+value);
				}else {//���fileitem�з�װ�����ϴ��ļ�;     �жϲ��Ǳ����͵ľ���file���͵ģ�
					String filename=item.getName();
					System.out.println(filename);
					if(filename==null||filename.trim().equals("")) {
						continue;
					}
					filename=filename.substring(filename.lastIndexOf("\\")+1);
					InputStream inputStream=item.getInputStream();
					FileOutputStream out=new FileOutputStream(savePath+"\\"+filename);
					byte buffer[]=new byte[1024];
					int len=0;
					while((len=inputStream.read(buffer))>0) {
						out.write(buffer,0,len);
					}
					inputStream.close();
					out.close();
					item.delete();
					message="�ļ��ϴ��ɹ�";
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="�ļ��ϴ�ʧ�ܣ�";
		} 
    	
//    	��ת
    	request.setAttribute("message", message);
    	request.getRequestDispatcher("message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}