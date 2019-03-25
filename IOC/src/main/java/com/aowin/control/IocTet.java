package com.aowin.control;

import com.aowin.cla.ClassA;
import com.aowin.cla.InterfaceOne;

public class IocTet {
	public void testInterface() {
		InterfaceOne io1=new ClassA();
		ClassA a1=new ClassA();
		io1.getInfo();
		a1.getInfo();
	}
}
