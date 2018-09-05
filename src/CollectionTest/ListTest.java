package CollectionTest;


import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;
/*
 * 多个线程同时操作ArrayList的时候，会抛出ConcurrentModificationException 的错
 * */
/*
 * List 使用场景
 *  1.单线程的多使用ArrayList、LinkedList，多线程使用Vector、stack
 *  2.快速访问使用ArrayList，添加删除使用LinkedList
 * */

public class ListTest {
    public static void main(String[] args) {
        // ArrayList arrayList=new ArrayList();
        //  List list=new ArrayList(); 向上转型,但是java不支持向下转型
        //     Float a=1.0;

        //   Collection是java.util下的接口，它是各种集合结构的父接口，比如List、Set  而Map没有实现Collection接口
        //  Collections是java.util下的类，它包含有各种有关集合操作的静态方法
        // Arrays

        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        //迭代器遍历
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        //ListIterator
        /*
        *队列迭代器，能够向前向后迭代
        * 具体Api:
            abstract boolean hasNext()
            abstract E next()
            abstract void remove()
            // 新增API接口
            abstract void add(E object)
            abstract boolean hasPrevious()
            abstract int nextIndex()
            abstract E previous()
            abstract int previousIndex()
            abstract void set(E object)
            涉及游标cursor

        *
        * */
        ListIterator listIterator = list.listIterator(1);  //指定游标开始的地方，从1开始，从第二个元素开始
//        ListItr(int index) {
//            super();
//            cursor = index;
//        }
        while (listIterator.hasNext()) {  //是否有下一个元素，有的话返回true

            if (listIterator.previous() != null) {  //cursor--
                listIterator.next(); //cursor++
                //System.out.println("prev "+listIterator.previousIndex()); //返回前一个元素的索引
            }
            System.out.println("next " + listIterator.next());
        }

        //随机访问
//        System.out.println(list.get(1));
        //for循环
//        for (Integer inte:list){
//            System.out.println(inte);
//        }

        //ToArray() Integer.ArrayList To Integer.Array 数据类型要保持一致
        Integer[] Array = {};
        Array = (Integer[]) list.toArray(Array);
        System.out.println(Array);

        //CopyOnWrite容器：写时复制容器，在操作时，先得到容器的副本，

        List<Integer> NumberList = new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for (int i = 0; i < NumberList.size(); ++i) {
            int v = NumberList.get(i);
            if (v % 2 == 0) {
                //  NumberList.remove(v); //移除后容量相应变小
            }
        }
        System.out.println(NumberList);

    }
}
