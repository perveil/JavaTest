package keywordTest;

import TestModel.Person;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/*
*垃圾回收线程扫描内存区域时，一旦发现了只具有弱引用的对象，不管当前内存空间是否足够都会回收其内存，
* 与软引用的区别就是
* 软引用是 发现了只具有软引用的对象，但是此时的内存空间很充足，此时也不会回收其内存
* 相同点是：
* 软引用在被垃圾回收机制回收的时候也可以关联一个软引用队列
*
* 延伸到WeakHashMap
*WeakHashMap的核心是把弱引用作为key的存储，当key所指向的对象的内存被回收时，
* key所对应的entry也会被remove掉
* 具体实现是：expungeStaleEntries()函数
*
* */

public class WeakReferenceReferenceQueueTest {
    public static void main(String[] args) {
        Person person=new Person("a",12);
        ReferenceQueue<Person> Queue=new ReferenceQueue<>();
        /*
        * 新建一个弱引用并且关联一个弱引用队列
        * */
        WeakReference<Person> personWeakReference= new WeakReference<Person>(person,Queue);
      //  Person StrongReference=personWeakReference.get(); 此时person 拥有一个强引用
        /* 置空弱引用所指向的对象*/
        person=null;

        System.gc(); //GC回收
        System.out.println(personWeakReference.get()); //指向的对象被垃圾回收机制回收,软引用失去作用 nulls
        System.out.println(Queue.poll()); //被回收的软引用被添加到了所关联的软引用的队列中

    }
}
