/*package com.aowin.classLoadSort;

public class MyClassLoader  extends ClassLoader{
*//**
 * �Զ����������
 * 1.�ҵ�ָ��class�ļ���ͨ��IO���ص��ڴ���
 *//*
	private String rootDir;
	public MyClassLoader(String rootDir) {
		this.rootDir=rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);//�������Ƿ񱻼��أ�
		
		if(c!=null) {//�Ѽ���--����
			return c;
		}else {//���丸�����
			ClassLoader parent=this.getParent();
			parent.loadClass(name);//ί�ɸ�����
			if(c!=null) {//�����ϴ�--������������ڲ��Ѿ���ƺ��ˣ�����ֻ��Ҫ�ύ��Ӧ�������������
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