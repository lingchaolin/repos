package com.aowin.Collectioning;

public class AAAAAA {
/**�����д�ŵĶ��Ƕ�������ã�
 * 
 */
/**���Ϸ���--��������-��ɾ�Ĳ�
Collection�ӿ�
	List(�б�)-���򣬿��ظ�-�����Է�ʽ����
		LinkedList 
		ArrayList 
		Vector 	 
			Stack
	Set(��)-���򣬲����ظ�(���Լ����ж��ظ��ķ���)��1.�ж�hashCode()-��ͬ�Ķ����Ȼ����ͬ��hashCode();2.eauals()�ж������Ƿ���ͬ
		HashSet
		TreeSet
Map
	Map(ӳ��)-��ż�ֵ��(-containsKey -containsValue --�Ƿ��������)
		Hashtable ---ͨ��ȱʡ��load factor 0.75�Ϻõ�ʵ����ʱ��Ϳռ�ľ��⡣
					����load factor���Խ�ʡ�ռ䵫��Ӧ�Ĳ���ʱ�佫�������Ӱ����get��put�����Ĳ�����
			Properties
		HashMap
		TreeMap 	
��iterator���������������в�Ҫͨ�����Ͻ�����ɾ���������ܻ���ִ���
�������ĵ����÷���
	Iterator it = collection.iterator(); // ���һ��������
	while(it.hasNext()) {
		Object obj = it.next(); // �õ���һ��Ԫ��
	}
Collection�涨��һ�����Ͼܾ�������Ԫ�أ�����ʲôԭ�򣬶������׳��쳣���������ֵ��ʾ��������add()ִ�к󣬼��ϵ������Ƿ���ˣ�����Ԫ������������λ�õȱ仯����

���õ�����--ʹ�õ�������������Ҫ�Լ��Ͻ��в�������Ҫͨ���������ķ���������������ܻ����
Iterator
	Iterator it=list.iterator();
	while(it.hasNext()){//hasNext()--�Ƿ�����һ��Ԫ�أ�
		Object obj = it.next(); //Next()--��ȡ��һ��Ԫ�أ�
	}
*/
//Collection��ʵ����Comparable�ӿ���Ԫ�ؿ���ʹ�ã�Collections.sort(staff)--ʵ������
/**ʵ��Comparable�ӿ�
 * int compareTo(Object o)ʵ��
 * 
 * 
 * Comparator�ӿ�--�Ƚ�����ʵ�ֶ�������ʽ
 * int compare(Object o1, Object o2)
 */

/**ArrayList
 * �ײ㣺��̬-����
 * ���򣬿��ظ�
 * �ŵ㣺��Ŀ�
 * ȱ�㣺��ɾ��
 * ����ͨ��index��������в�����
 * �����ݣ����Ϊ��1024��?
 * 	
 */
/**LinkedList
 * �ײ㣺˫������
 * ���򣬿��ظ�
 * �ŵ㣺��ɾ��
 * ȱ�㣺�����
 * ����ͨ��index��������в�����
 * ������ͨ��First,Last���������βԪ�ؽ��в�����
 * LinkedList�ṩ��һЩ������ʹ֮���Ե�����ջ�Ͷ�����ʹ��
 */
/**Vector
 * ����ArrayList
 * ������ListB��ͬ����:Vector���̰߳�ȫ��--���̰߳�ȫ����ζ��Ч�ʵ���;
 * 
 * 		Stack�̳���Vector��ʵ��һ������ȳ��Ķ�ջ
 * 		 pop() push() peek()�õ�ջ��Ԫ��	��empty()���Զ�ջ�Ƿ�Ϊ��
 * 		stack�մ���ʱ�ǿ�ջ
 */
/**ArrayList��Vector������
	��ͬ�㶼�̳���List�ӿ�-�������򼯺ϣ��ɰ��������Ŵ�ȡȡԪ�أ����е������������ظ��ģ�
	����
	1.	Vector���̰߳�ȫ�ģ�-�������߳�ͬ���ģ�
		AyyayList���̲߳���ȫ�ģ�--����֮���ǲ�ͬ���ģ�
			ֻ��һ���̷߳��ʵ�����£������ArrayList���������̣߳�Ч�ʸߣ�
	2.	��������--Ԫ�ظ�����������ʱ��������ݽ������ݣ�
		Vector����һ����
		ArrayList����0.5����
 */
/**HashSet
 * �ײ㣺ʹ��HashMap��һ������ʵ��
 * ���򣬲����ظ�--1.hashCode();2.equals();
 */
/**TreeSet
 * �ڼ���������Զ�������ļ���ʵ�֡�
 * ����ζ�Ŵ�һ��TreeSet�����õ�һ�����������������ṩ����
 */
/**Map-Hashtable--ע��Hashtable�� HashMap������
 * ���ࣺDictionary
 * ��-Key:�����ظ�������Ϊnull;
 * ֵ-Value:����Ϊnull;
 * �̰߳�ȫ�ģ�
 * 	Properties��
 *	-Hashtable������
 *	 ���ã���д��Դ�����ļ���
 *	  ����ֵֻ��Ϊ�ַ���
 */
/**Map-HashMap
 * ���ࣺAbstractMap
 * ��-Key:�����ظ�������Ϊnull;
 * ֵ-Value:����Ϊnull;
 * ���̰߳�ȫ�ģ�
 */	

/**Map-TreeMap
 *  ȷ��key��������(Comparable--ʵ��compareTo()����)
 *  �����ṩ�Ƚ���(Comparator--int compare(Object o1, Object o2))��
 */
	
/**
1.����ͼ��ϵ�����
	������Դ�Ż����������ͣ�Ҳ�ɴ�Ŷ��󣬵�һ���������ͣ�ֻ�ܴ��һ�����͵�����
		���鳤�ȹ̶�
	���Ͽ��Դ���κζ���(����ֱ�Ӵ�Ż����������ͣ���Ҫ��������������װ��)��
		���ϵĳ������ɱ䣻
2.Colection�Ǽ��������ϲ�Ľӿ�
*/
/**����Queue��Deque
Enumeration
Hashtable��Properties
	Hashtable�� HashMap
	Properties:��Դ���õĶ�д����
WeakHashMap
IdentityHashMap��EnumMap
ͬ�����ƺ�ֻ������
	����Queue����-һ�˲���
		fifo
		���ȺͶ�ջ��lifo
	Deque˫��-���˲���
	
Properties��
	-Hashtable������
	 ���ã���д��Դ�����ļ���
	  ����ֵֻ��Ϊ�ַ���
setProperty(String key,String value)
setProperty(String key)
setProperty(String key,String defaultValue)
��׺��
store(OutputStream out, String comments) 
store(Writer writer, String comments)
load(InputStream inStream) 
load(Reader reader) 
		  
.xml
storeToXML(OutputStream os, String comment) --Ĭ��"utf-8";
storeToXML(OutputStream os, String comment, String encoding) 
loadFromXML(InputStream in)
*/

/**21.ArrayList��Vector������
���̳���List�ӿ�-�������򼯺ϣ��ɰ���������ȡԪ�أ����е������������ظ��ģ�
		--(HashSet֮��ļ��ϲ����԰����������ң�Ҳ�������ظ�)
	����
	1.	Vector���̰߳�ȫ�ģ�-�������߳�ͬ���ģ�
		AyyayList���̲߳���ȫ�ģ�--����֮���ǲ�ͬ���ģ�
		ֻ��һ���̷߳��ʵ�����£������ArrayList���������̣߳�Ч�ʸߣ�
	2.	��������
		Ԫ�ظ�����������ʱ��������ݽ������ݣ�
		Vector����һ����
		ArrayList����0.5����
*/
/**HashMap��HashTable������
HashMap��HashTable��������ʵ�֣����̰߳�ȫ��ʵ�֣������Ƕ������Map�ӿڣ�
HashMap		����һ��key/���valueΪnull;	���̰߳�ȫ--Ч�ʸߣ�	�̳���Map
HashTable	key/value����Ϊnull;			�̰߳�ȫ----Ч�ʵͣ�	�̳���Dictionary;
*/
/**list �� Map ������
List	�洢�������ݵĽ��		���������ظ�
Map		�洢��ֵ��				���򡢼�ֵ�����ظ�--value�����ظ�
*/
/**Lsit/Set�̳���Collection�ӿڣ�Map����


*/
/**List��Set��Map�����ӿڴ�ȡԪ��ʱ������ʲô�ص㣿
List	��Ԫ�ؼ���	���ظ�			����-����ͨ��index��ȡԪ��
Set		��Ԫ�ؼ���	�������ظ�Ԫ��	����
Map		��ֵ�Լ���
*/
/**˵��ArrayList,Vector,LinkedList�Ĵ洢���ܺ����ԣ�
ArrayList	����洢	���̰߳�ȫ
Vector		����洢	�̰߳�ȫ----Ч�ʵͣ�
LinkedList	˫������ʵ�ִ洢	�̲߳���ȫ
*/
/**ȥ��һ��Vector�������ظ���Ԫ��
Vector newVector=new Vector();
for(int i=0;i<vector.size();i++){
	Object obj=vector.get(i);
	if(!newVector.contains(obj)){
		newVector.add(obj);
	}
}
��--����Map�������ظ����ص�
HashSet set=new HashSet(vector);
*/
/**Collection��Collections������
	Collection�Ǽ�������ϼ��ӿڣ��̳����Ľӿ���Ҫ��Set��List.
	Collections����Լ������һ�������࣬���ṩһϵ�о�̬����ʵ����Ը��ּ��ϵ������������̰߳�ȫ���Ȳ�����
*/
/**SetԪ�ز������ظ�����ô�жϵģ�
 * 1.hashCode()
	.equals();
 */
/**˵������֪���ļ����඼����Щ����Ҫ������
List�ľ���ʵ�ְ���ArrayList��Vector,�����ǿɱ��С���б��Ƚ��ʺϹ������洢�Ͳ����κ����Ͷ����Ԫ���б�
List�����ڰ���ֵ��������Ԫ�ص�����

Map-��ֵ�ԣ�ÿ����ӳ�䵽һ��ֵ��

������ɾ�Ĳ�ķ�����
Map	put		remove	contains
set	add		remove	contains
List	-index
*/
	public static void main(String[] args) {

	}
	
}