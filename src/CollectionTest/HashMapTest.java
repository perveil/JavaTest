package CollectionTest;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
/*
* public class HashMap<K,V> extends AbstractMap<K,V>
    implements Map<K,V>, Cloneable, Serializable {
    AbstractMap 实现了Map接口，HashMap继承自AbstractMap,AbstractMap实现了Map的大部分方法
    线程不安全
    http://www.cnblogs.com/skywang12345/p/3310835.html //详情请看这篇博文

* */

/*
 * Map允许键、值为null;
 * */

/*   问题1：
  final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        //计算容量
        if (s > 0) {
            if (table == null) { // pre-size
                float ft = ((float)s / loadFactor) + 1.0F;
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                         (int)ft : MAXIMUM_CAPACITY);
                if (t > threshold)
                    threshold = tableSizeFor(t);
            }
            else if (s > threshold)
                resize();
              //循环为其赋值
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                putVal(hash(key), key, value, false, evict);
            }
            // 继续查看putVal()函数可以发现 Map的拷贝只是拷贝了Map的第一个元素，而不是一整个Entry链
        }
    }

* */
/*HashTable 类声明
* 1.public class Hashtable<K,V>
    extends Dictionary<K,V>
    implements Map<K,V>, Cloneable, java.io.Serializable {
*实现了Map、Dictionary接口，线程安全，与HashMap一样都是散列表，使用拉链法解决Hash冲突
* 2.
*  public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
        HashTable不允许键值出现Null，出现则抛出 NullPointerException();
* */
public class HashMapTest {
    public static void main(String[] args) {
 //1.
       Map Test = new HashMap<Integer, String>();
//        Test.put(null, "s");
//        Test.put(1, null);




        Dictionary table=new Hashtable<String,Integer>();

    }
}
