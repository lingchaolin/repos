/*package com.aowin.classLoadSort;

public class MyClassLoader  extends ClassLoader{
*//**
 * 自定义类加载器
 * 1.找到指定class文件，通过IO加载到内存中
 *//*
	private String rootDir;
	public MyClassLoader(String rootDir) {
		this.rootDir=rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);//看该类是否被加载；
		
		if(c!=null) {//已加载--返回
			return c;
		}else {//让其父类加载
			ClassLoader parent=this.getParent();
			parent.loadClass(name);//委派给父类
			if(c!=null) {//继续上传--各个类加载器内部已经设计好了，这里只需要提交的应用类加载器即可
				return c;
			}else {
				byte[] classData=getClassLoader(name);
				if(c!=null) {
					throw new ClassNotFoundException();
				}else {
					c=definedClass(name,classData,0,classData.length);
				}
			}
		}
	}

}
*/