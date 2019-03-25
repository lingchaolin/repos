package com.aowin.Collectioning;

import java.util.Map;

/**
 * 自己实现Map;
 * 键值对存放--key值不重复-根据对象找对应的值
 * @author Administrator
 *
 */
public class MySxtMap {
	static MySxtMap m=new MySxtMap();
	private int size;
//	private Object arr[];
	Entry []arr=new Entry[999];
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void put(Object key,Object value){
		if(!containsKey(key)){
			Entry e=new Entry(key,value);
			arr[size++]=e;
		}else{
			for(int i=0;i<m.size;i++){
				if(arr[i].key.equals(key)){
					arr[i].value=value;
				}
			}
		}
	}
	public boolean containsKey(Object key){
		for(int i=0;i<m.size;i++){
			if(arr[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	public boolean containsValue(Object value){
		for(int i=0;i<m.size;i++){
			if(arr[i].value.equals(value)){
				return true;
			}
		}
		return false;
	}
	public void remove(Object key){
		for(int i=0;i<m.size;i++){
			if(arr[i].key.equals(key)){
				System.arraycopy(arr, i+1, arr, i, size-i);
				size--;
			}
		}
	}
	/**
	 * 为了方便检验程序是否正确，新建了getkey和getValue;
	 * @param args
	 */
	public Object getkey(int index){
		return arr[index].key;
	}
	public Object getvalue(int index){
		return arr[index].value;
	}
	public static void main(String[]args){
//		Map map;
		
		m.put(0, "zero");
		m.put(1,"one");
		m.put(2,"two" );
		m.put(3,"three" );
		m.put(4,"four");
		m.put(5,"five");
		m.put(6,"six" );
		m.put(7,"seven" );
		m.put(8,"eight");
		m.remove(2);
		
		for(int i=0;i<m.size;i++){
//			System.out.println(i+"="+m.get(i));
			System.out.println("编号为"+i+":"+m.getkey(i)+"="+m.getvalue(i));
		}
//		System.out.println(m.containsValue("one"));
//		System.out.println(m.containsValue(9));
		System.out.println(m.size);
	}

}
class Entry{
	Object key;
	Object value;
	
	public Entry() {
		super();
	}
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
