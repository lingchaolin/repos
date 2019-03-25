package com.aowin.IOC;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SequenceSix{
	@Resource
	private SequenceOne one;
	@Resource(name="sequenceOne")  //byNameע��
	private SequenceOne two;
	@Autowired  //byTypeע��
	private SequenceOne three;
	@Autowired
	@Qualifier("sequenceOne")//Qualifier��Autowired���ʹ�ã�ָ��bean������--byNameע��
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
