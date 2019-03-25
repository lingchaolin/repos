package com.aowin.Swing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class GameUtil {
	private GameUtil(){}//��������ý�������˽���ˡ�
	/**
	 * һ��Ҫ�й�������Ϊʲô����
	 * @param path
	 * @return
	 */
	public static Image getImage(String path){
		BufferedImage bi=null;
		try {
			URL u=GameUtil.class.getClassLoader().getResource(path);
//			System.out.println(u);
			bi=javax.imageio.ImageIO.read(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bi;
	}
}