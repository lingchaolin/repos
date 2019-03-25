package com.aowin.Collectioning;

public class AAAAAA {
/**集合中存放的都是对象的引用；
 * 
 */
/**集合分类--基本方法-增删改查
Collection接口
	List(列表)-有序，可重复-以线性方式储存
		LinkedList 
		ArrayList 
		Vector 	 
			Stack
	Set(集)-无序，不可重复(有自己的判断重复的方法)：1.判读hashCode()-相同的对象必然有相同的hashCode();2.eauals()判断内容是否相同
		HashSet
		TreeSet
Map
	Map(映射)-存放键值对(-containsKey -containsValue --是否包含……)
		Hashtable ---通常缺省的load factor 0.75较好地实现了时间和空间的均衡。
					增大load factor可以节省空间但相应的查找时间将增大，这会影响像get和put这样的操作。
			Properties
		HashMap
		TreeMap 	
在iterator迭代器迭代过程中不要通过集合进行增删操作，可能会出现错误；
迭代器的典型用法：
	Iterator it = collection.iterator(); // 获得一个迭代子
	while(it.hasNext()) {
		Object obj = it.next(); // 得到下一个元素
	}
Collection规定：一个集合拒绝添加这个元素，无论什么原因，都必须抛出异常，这个返回值表示的意义是add()执行后，集合的内容是否改了（就是元素有无数量、位置等变化）。

调用迭代器--使用迭代器过程中若要对集合进行操作；需要通过迭代器的方法操作，否则可能会出错；
Iterator
	Iterator it=list.iterator();
	while(it.hasNext()){//hasNext()--是否有下一个元素？
		Object obj = it.next(); //Next()--获取下一个元素；
	}
*/
//Collection中实现了Comparable接口列元素可以使用：Collections.sort(staff)--实现排序
/**实现Comparable接口
 * int compareTo(Object o)实现
 * 
 * 
 * Comparator接口--比较器，实现多种排序方式
 * int compare(Object o1, Object o2)
 */

/**ArrayList
 * 底层：动态-数组
 * 有序，可重复
 * 优点：查改快
 * 缺点：增删慢
 * 可以通过index对链表进行操作；
 * 可扩容，最大为（1024）?
 * 	
 */
/**LinkedList
 * 底层：双向链表
 * 有序，可重复
 * 优点：增删快
 * 缺点：查改慢
 * 可以通过index对链表进行操作；
 * 还可以通过First,Last对链表的首尾元素进行操作；
 * LinkedList提供了一些方法，使之可以当做堆栈和队列来使用
 */
/**Vector
 * 类似ArrayList
 * 与其他ListB不同的是:Vector是线程安全的--但线程安全就意味着效率低下;
 * 
 * 		Stack继承自Vector，实现一个后进先出的堆栈
 * 		 pop() push() peek()得到栈顶元素	、empty()测试堆栈是否为空
 * 		stack刚创建时是空栈
 */
/**ArrayList和Vector的区别？
	共同点都继承了List接口-都是有序集合；可按照索引号存取取元素，其中的数据是允许重复的，
	区别：
	1.	Vector是线程安全的；-方法是线程同步的；
		AyyayList是线程不安全的，--方法之间是不同步的；
			只有一个线程访问的情况下，最后用ArrayList，不考虑线程，效率高；
	2.	数据增长--元素个数超过容量时，会对数据进行扩容，
		Vector增加一倍；
		ArrayList增加0.5倍；
 */
/**HashSet
 * 底层：使用HashMap的一个集的实现
 * 无序，不可重复--1.hashCode();2.equals();
 */
/**TreeSet
 * 在集中以升序对对象排序的集的实现。
 * 这意味着从一个TreeSet对象获得第一个迭代器将按升序提供对象。
 */
/**Map-Hashtable--注意Hashtable与 HashMap的区别！
 * 父类：Dictionary
 * 键-Key:不可重复，不能为null;
 * 值-Value:不能为null;
 * 线程安全的；
 * 	Properties：
 *	-Hashtable的子类
 *	 作用：读写资源配置文件；
 *	  键或值只能为字符串
 */
/**Map-HashMap
 * 父类：AbstractMap
 * 键-Key:不可重复，可以为null;
 * 值-Value:可以为null;
 * 非线程安全的；
 */	

/**Map-TreeMap
 *  确保key可以排序(Comparable--实现compareTo()方法)
 *  或者提供比较器(Comparator--int compare(Object o1, Object o2))；
 */
	
/**
1.数组和集合的区别
	数组可以存放基本数据类型，也可存放对象，但一旦定义类型，只能存放一种类型的数据
		数组长度固定
	集合可以存放任何对象(不能直接存放基本数据类型，需要将基本数据类型装箱)；
		集合的长度灵活可变；
2.Colection是集合类最上层的接口
*/
/**队列Queue与Deque
Enumeration
Hashtable与Properties
	Hashtable与 HashMap
	Properties:资源配置的读写工作
WeakHashMap
IdentityHashMap与EnumMap
同步控制和只读设置
	队列Queue单向-一端操作
		fifo
		优先和堆栈：lifo
	Deque双向-两端操作
	
Properties：
	-Hashtable的子类
	 作用：读写资源配置文件；
	  键或值只能为字符串
setProperty(String key,String value)
setProperty(String key)
setProperty(String key,String defaultValue)
后缀：
store(OutputStream out, String comments) 
store(Writer writer, String comments)
load(InputStream inStream) 
load(Reader reader) 
		  
.xml
storeToXML(OutputStream os, String comment) --默认"utf-8";
storeToXML(OutputStream os, String comment, String encoding) 
loadFromXML(InputStream in)
*/

/**21.ArrayList和Vector的区别？
都继承了List接口-都是有序集合；可按照索引号取元素，其中的数据是允许重复的，
		--(HashSet之类的集合不可以按照索引查找，也不允许重复)
	区别：
	1.	Vector是线程安全的；-方法是线程同步的；
		AyyayList是线程不安全的，--方法之间是不同步的；
		只有一个线程访问的情况下，最后用ArrayList，不考虑线程，效率高；
	2.	数据增长
		元素个数超过容量时，会对数据进行扩容，
		Vector增加一倍；
		ArrayList增加0.5倍；
*/
/**HashMap和HashTable的区别
HashMap是HashTable的轻量级实现（非线程安全的实现），他们都完成了Map接口；
HashMap		允许一个key/多个value为null;	非线程安全--效率高；	继承自Map
HashTable	key/value不能为null;			线程安全----效率低；	继承自Dictionary;
*/
/**list 和 Map 的区别；
List	存储单列数据的结合		有序、允许重复
Map		存储键值对				无序、键值不能重复--value可以重复
*/
/**Lsit/Set继承自Collection接口；Map不是


*/
/**List、Set、Map三个接口存取元素时，各有什么特点？
List	单元素集合	可重复			有序-可以通过index存取元素
Set		单元素集合	不允许重复元素	无序，
Map		键值对集合
*/
/**说出ArrayList,Vector,LinkedList的存储性能和特性；
ArrayList	数组存储	非线程安全
Vector		数组存储	线程安全----效率低；
LinkedList	双向链表实现存储	线程不安全
*/
/**去掉一个Vector集合中重复的元素
Vector newVector=new Vector();
for(int i=0;i<vector.size();i++){
	Object obj=vector.get(i);
	if(!newVector.contains(obj)){
		newVector.add(obj);
	}
}
或--利用Map键不可重复的特点
HashSet set=new HashSet(vector);
*/
/**Collection和Collections的区别。
	Collection是集合类的上级接口，继承他的接口主要是Set和List.
	Collections是针对集合类的一个帮助类，他提供一系列静态方法实现针对各种集合的搜索，排序，线程安全化等操作。
*/
/**Set元素不允许重复，怎么判断的？
 * 1.hashCode()
	.equals();
 */
/**说出你所知道的集合类都有哪些？主要方法？
List的具体实现包括ArrayList和Vector,他们是可变大小的列表；比较适合构建，存储和操作任何类型对象的元素列表；
List适用于按数值索引访问元素的情形

Map-键值对，每个键映射到一个值；

都有增删改查的方法；
Map	put		remove	contains
set	add		remove	contains
List	-index
*/
	public static void main(String[] args) {

	}
	
}