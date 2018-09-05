package CollectionTest;

import TestModel.Person;

import java.util.*;
/*
* TreeSet/TreeMap 实现了SortSet/SortedMap接口，而所有的SortSet/SortedMap 实现类都应该提供4个构造函数
*    (01) void（无参数）构造方法，它创建一个空的有序映射，按照键的自然顺序进行排序。
    (02) 带有一个 Comparator 类型参数的构造方法，它创建一个空的有序映射，根据指定的比较器进行排序。
    (03) 带有一个 Set/Map 类型参数的构造方法，它创建一个新的有序映射，其键-值映射关系与参数相同，按照键的自然顺序进行排序。
    (04) 带有一个 SortedSet/SortedMap 类型参数的构造方法
* */
        /*
        SortedSet 接口所提供的方法
        java.util.SortedSet.comparator()//自己定义比较器，对内部元素排序
        java.util.SortedSet.first()//第一个元素
        java.util.SortedSet.headSet(E e)//e之前的元素，不包括e
        java.util.SortedSet.last()//最后一个元素
        java.util.SortedSet.spliterator()//Java8新增，生成Spliterator接口，有点类似nio里的selector
        java.util.SortedSet.subSet(E e1, E e2)//e1和e2之间的元素
        java.util.SortedSet.tailSet(E e)//e之后的元素，包括e
        *
        * SortedMap与之类似
        * */

public class SortedSetTest {
    public static void main(String[] args) {
        /*
        * public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, java.io.Serializable
        *  public interface NavigableSet<E> extends SortedSet<E> {
        *TreeSet实现了 NavigableSet 而NavigableSet 继承于SortedSet 所以TreeSet既有排序功能，也有定位排序功能
        * */
        SortedSet<Person> sortedSet=new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        Person m1=new Person("13",13);
        Person m2=new Person("12",12);
        sortedSet.add(m1);
        sortedSet.add(m2);
        System.out.println(sortedSet.first().getName());
        System.out.println(sortedSet.last().getName());


        Iterator iterator=sortedSet.iterator();
        while(iterator.hasNext()){
            Person person= (Person) iterator.next();
            System.out.println("person name"+person.getName());
        }

        /*
        *SortedMap 是一个继承于Map接口的接口，排序方式有两种，自然排序和用户指定排序器
        * 自然排序是按照key的值大小进行排序
        * */
        NavigableMap<String,Integer> sortedTreeMap = new TreeMap<String,Integer>();
        Iterator iterator1=sortedTreeMap.entrySet().iterator();
        sortedTreeMap.put("bb", 22);
        sortedTreeMap.put("aa", 11);
        sortedTreeMap.put("cc", 33);
        sortedTreeMap.put("ee", 55);
        sortedTreeMap.put("dd", 44);

        System.out.println("共有多少个元素：" + sortedTreeMap.size());
        System.out.println("倒序" +  sortedTreeMap.descendingKeySet());
        /*
        *NavigableMap 接口实现倒序keySet
        * */
        Iterator iterator2=sortedTreeMap.entrySet().iterator();
        while (iterator2.hasNext()){
            Map.Entry entry= (Map.Entry) iterator2.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }



        System.out.println("higherKey()方法" + ((TreeMap<String, Integer>) sortedTreeMap).higherKey("cc"));
        System.out.println("entrySet：" + sortedTreeMap.entrySet());
        System.out.println("第一个元素：" + sortedTreeMap.firstKey());
        System.out.println("最后一个元素：" + sortedTreeMap.lastKey());
        System.out.println("headSet元素：" + sortedTreeMap.headMap("cc"));//cc之前的元素
        System.out.println("tailSet元素：" + sortedTreeMap.tailMap("cc"));//cc之后的元素
        System.out.println("subSet元素：" + sortedTreeMap.subMap("aa", "dd"));//aa到dd之间的元素
        System.out.println("subSet元素：" + sortedTreeMap.values());//values,所有的value值


    }
}
