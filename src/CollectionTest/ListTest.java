package CollectionTest;


import java.util.*;

public class ListTest {
    public static void main(String[] args) {
       // ArrayList arrayList=new ArrayList();
       //  List list=new ArrayList(); 向上转型,但是java不支持向下转型
       //     Float a=1.0;

        //   Collection是java.util下的接口，它是各种集合结构的父接口，比如List、Set  而Map没有实现Collection接口
        //  Collections是java.util下的类，它包含有各种有关集合操作的静态方法
       // Arrays

        ArrayList<Integer> list=new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Integer(2));
        //迭代器遍历
//        Iterator  iter=list.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
        //随机访问
//        System.out.println(list.get(1));
        //for循环
//        for (Integer inte:list){
//            System.out.println(inte);
//        }

        //ToArray() Integer.ArrayList To Integer.Array 数据类型要保持一致
        Integer  [] strArray={};
        strArray=(Integer [])list.toArray(strArray);
        System.out.println(strArray);

    }
}
