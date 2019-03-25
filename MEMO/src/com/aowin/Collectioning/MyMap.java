package com.aowin.Collectioning;

import java.util.Map;

public class MyMap {
	static MyMap m=new MyMap();

	int size;
//	int lixe;
	static SxtEntry[]arr=new SxtEntry[999];
//	static SxtEntry[]array=new SxtEntry[3];
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void clear(){
		for(int i=0;i<m.size;i++){
			arr[i]=null;
		}
	}
	
//	public void putAll(SxtEntry2 array[]){
////		System.arraycopy(array, 0, arr, size, array.length);
////		size+=array.length;
//		for(int i=0;i<lixe;i++){
//			arr[size+i]=array[i];
//			size+=lixe;
//		}
//	}
	public void remove(Object key){
		for(int i=0;i<m.size;i++){
			if(arr[i].key.equals(key)){
//				for(int j=i;j<m.size;j++){
//					arr[j]=arr[j+1];
//				}
				System.arraycopy(arr, i+1, arr, i, size-i-1);
				size--;
				return ;
			}
		}
	}
	public void put(Object key,Object value){
		SxtEntry e=new SxtEntry(key,value);
		arr[size++]=e;
	}
//	public void put2(Object key,Object value){
//		SxtEntry e=new SxtEntry(key,value);
//		array[lixe++]=e;
//	}
	public Object get(Object key){
		for(int i=0;i<m.size;i++){
			if(arr[i].key.equals(key)){
				return arr[i].value;
			}
		}
		return null;
	}
	public Object getkey(int index){
		return arr[index].key;
	}
	public Object getvalue(int index){
		return arr[index].value;
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
	public static void main(String[]args){
//		static SxtMap2 m=new SxtMap2();
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
//		m.put2(0, "zero");
//		m.put2(1,"one");
//		m.put2(2,"two" );
//		m.putAll(array);
//		System.out.println("±àºÅÎª"+m.getkey(1)+"="+m.getvalue(1));
		for(int i=0;i<m.size;i++){
//			System.out.println(i+"="+m.get(i));
			System.out.println("±àºÅÎª"+i+":"+m.getkey(i)+"="+m.getvalue(i));
		}
//		System.out.println(m.containsValue("one"));
//		System.out.println(m.containsValue(9));
		System.out.println(m.size);
		Map map;
	}
}

class SxtEntry{
	Object key;
	Object value;
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}