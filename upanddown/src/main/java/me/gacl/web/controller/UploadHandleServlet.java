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
//     获取源地址
//    	是否正确
    	
//    	获取目标地址--字符串转化成目录
    	String savePath=this.getServletContext().getRealPath("/WEB-INF/upload");
    	System.out.println();
    	File file=new File(savePath);
//    	是否正确
    	if(!file.exists()&&!file.isDirectory()) {
    		System.out.println(savePath+"目录不存在，需要创建！");
    		file.mkdirs();
    	}
    	String message="";
    	try {
	//    	使用Apache文件上传组件处理文件上传步骤：
	//    	1.创建一个DiskFileItemFactory工厂
	    		DiskFileItemFactory factory=new DiskFileItemFactory();
	//    	2.创建上传文件的解析器
	    		ServletFileUpload fileUpload=new ServletFileUpload(factory);
	    		fileUpload.setHeaderEncoding("UTF-8");
	//    	3.判读提交上来的数据是否是上传表单的数据
	    		if(!ServletFileUpload.isMultipartContent(request)) {//判断是否包含多部分的内容（在这里可能是上传的文件）
	    			return;
	    		}
	//    	4.解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem>list=fileUpload.parseRequest(request);
			for(FileItem item:list) {
				//如果fileitem中封装的是普通输入项的数据
//				判断某项是否是普通的表单类型。
				if(item.isFormField()) {
					String name=item.getFieldName();
					String value=item.getString("UTF-8");
					System.out.println(name+"="+value);
				}else {//如果fileitem中封装的是上传文件;     判断不是表单类型的就是file类型的；
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
					message="文件上传成功";
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="文件上传失败！";
		} 
    	
//    	跳转
    	request.setAttribute("message", message);
    	request.getRequestDispatcher("message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}