package com.aowin.Collectioning;

public class MySxtArrayList {
	/**
	 * 自己实现ArrayList部分功能
	 * 
	 * @param args
	 */
	int size;
	Object element[];
	public MySxtArrayList(){
		this(10);
	}
	public MySxtArrayList(int initialCapacity){
		if(initialCapacity<0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		element=new Object[initialCapacity];
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public void add(Object obj){
		ensureCapacity();
		element[size++]=obj;
	}
	
	public void ensureCapacity(){
		if(size>=element.length){
			Object newArray[]=new Object[2*size+1];
			System.arraycopy(element, 0, newArray, 0, size);
			element=(Object[]) newArray;
		}
	}
	public boolean rangeCheck(int index){
		if(index<0||index>size){
			return false;
		}
		return true;
	}
	public void add(int index,Object obj){
		if(rangeCheck(index)){
			System.arraycopy(element, index, element, index+1, size-index);
			element[index]=obj;
		}
	}
	public void set(int index,Object obj){
		rangeCheck(index);
		element[index]=obj;
	}
	public Object get(int index){
		rangeCheck(index);
		return element[index];
		
	}
	public void remove(Object obj){
		if(obj==null){
			for(int i=0;i<size;i++){
				if(element[i]==null){
					remove(i);
				}
			}
		}else{
			for(int i=0;i<size;i++){
				if(element[i].equals(obj)){
					remove(i);
				}
			}
		}
	}
	public void remove(int index){
		rangeCheck(index);
		System.arraycopy(element, index+1, element, index, size-index);
		size--;
	}
	public void clear(){
		for(int i=0;i<size;i++){
			element[i]=null;
		}
		size=0;
	}
//	public void remove(Object obj){
//		if(obj==null){
//			for(int index=0;index<size;index++)
//				if(element[index]==null){
//					remove(index);
//				}
//		}else{
//			for(int index=0;index<size;index++)
//				if(obj.equals(element[index])){
//					remove(index);
//				}
//		}
//	}
//	public void clear(){
//		for(int i=0;i<size();i++)
//			element[i]=null;
//		size=0;
//	}
	
	
	
	
	public static void main(String[]args){
		MySxtArrayList list=new MySxtArrayList();
		list.add("000");
		list.add("111");
		list.add("222");
		list.add("333");
		list.add("444");
		list.add("555");
//		list.add(2, "ooo");
//		list.set(2, "ooo");
//		list.remove(2);
		list.remove("222");//?????
		for(int i=0;i<list.size;i++){
			System.out.println(list.get(i));
		}
		System.out.print(list.size);
	}
}
