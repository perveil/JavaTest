package GenericTest;

import java.util.*;

class Apple{

}
class Orgne{

}

class SubApple extends Apple{

}

public class SuppressWaringsTest<T,E> {
    public static void main(String[] args) {
        //情形一：原生态类型List 躲避了泛型检查,编译时因为不检查所以不报错
        // @SuppressWarnings("unchecked") 注解是 告诉编译器不要去进行类型检查
        @SuppressWarnings("unchecked")
        List nameList=new ArrayList<Integer>();
        nameList.add("ww");
        nameList.add(new Integer(12));
        System.out.println(nameList.toString());
        //情形二：
        List<Integer> nameList1=new ArrayList<Integer>();
        //nameList1.add("ww"); //参数型泛型，编译时泛型检查，提示报错
        nameList1.add(new Integer(12));
        System.out.println(nameList1.toString());
        //情形三：
       List orgneList=new ArrayList<Orgne>();
       orgneList.add(new Apple());
       orgneList.add(new Orgne());
       System.out.println(orgneList.get(1));
       //情形四：List<Object>  List   List<Integer>
       // Test(nameList1);  // List<Integer>  不是List<Object>的子类型，而是List的子类型

        //情形五:数组是协变的，SubApple[] 是Apple  []的子类型
         Apple  [] apples=new SubApple[2];
       // List<Apple> appleList=new ArrayList<SubApple>(); 编译出错，泛型是不变的，ArrayList<SubApple> 不是List<Apple> 的子类型


    }

    public static void Test(List<Object> list ){

    }
    public  T Test2(T list ){
       // T [] Ts=new T[2];  //编译不通过，是因为不能创建不可具体化类型的数组，T 是一个泛型类型，无法具体化
        T [] Ts=( T [])new Object[2];  // 不安全，可能出现ClassCastException异常，因为涉及类型强制性转换
        return list;
    }
    public  Set Test3(Set<E> set, Set<E> set2){
     Set<E> result=new HashSet<>();
     result.addAll(set2);
     return result;
    }
}
