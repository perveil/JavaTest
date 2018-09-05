package CollectionTest;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector();
        /*
        Vector 是线程安全的
        在构造函数里边可以提供初始容量，容量增长指数，默认每一次调整都会增长一倍
        * */
        vector.add(1);
        vector.add(2);
        vector.add(3);

        Enumeration enumeration = vector.elements();
        System.out.println(enumeration.nextElement());
        System.out.println(enumeration.nextElement());
        /*
         public Enumeration<E> elements() {
        return new Enumeration<E>() { 匿名类的使用
            int count = 0;

            public boolean hasMoreElements() {
                return count < elementCount;
            }

            public E nextElement() {
                synchronized (Vector.this) {
                    if (count < elementCount) {
                        return elementData(count++); // Count++
                    }
                }
                throw new NoSuchElementException("Vector Enumeration");
            }
        };
    }
        * */

        //toArray()
        /*
            public synchronized <T> T[] toArray(T[] a) {
            if (a.length < elementCount) //传入的数组的尺寸如果小于vector的长度，就返回一个扩大了的新数组
                return (T[]) Arrays.copyOf(elementData, elementCount, a.getClass());

                System.arraycopy(elementData, 0, a, 0, elementCount);

                if (a.length > elementCount)
                    a[elementCount] = null;

                return a;
            }
        * */
        Integer[] Array = new Integer[3];
        vector.toArray(Array);
        System.out.println(Array[2]);

        //subList  继承了list的subList方法,相当于String的subString，截止到toIndex的前一位
        List list = vector.subList(0, 2);
        System.out.println(list);

        //遍历方式
        //1.interator遍历 2 随机访问  3.for循环  4.enumeration遍历
    }
}
