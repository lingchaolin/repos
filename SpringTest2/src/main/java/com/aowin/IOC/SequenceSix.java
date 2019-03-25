package com.aowin.IOC;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SequenceSix{
	@Resource
	private SequenceOne one;
	@Resource(name="sequenceOne")  //byName注入
	private SequenceOne two;
	@Autowired  //byType注入
	private SequenceOne three;
	@Autowired
	@Qualifier("sequenceOne")//Qualifier和Autowired配合使用，指定bean的名称--byName注入
	private SequenceOne four;
	public SequenceSix() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the one
	 */
	public SequenceOne getOne() {
		return one;
	}
	/**
	 * @return the two
	 */
	public SequenceOne getTwo() {
		return two;
	}
	/**
	 * @return the three
	 */
	public SequenceOne getThree() {
		return three;
	}
	/**
	 * @return the four
	 */
	public SequenceOne getFour() {
		return four;
	}
	
}
