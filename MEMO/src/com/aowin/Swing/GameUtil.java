package com.aowin.Swing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class GameUtil {
	private GameUtil(){}//工具类最好将构造器私有了。
	/**
	 * 一定要有构造器？为什么？？
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