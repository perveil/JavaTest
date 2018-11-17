package GenericTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
https://www.cnblogs.com/heimianshusheng/p/5766573.html
泛型的类型推导
* */
public class FindTest<T> {

    <T> FindTest(T a){
    }

    public static void main(String[] args) {
       //类型推导只能根据调用的参数类型、目标类型进行推导，而不能根据程序后面的一些需求来进行推导。

        //情形一：编译出错，泛型被多处不同的使用之后，与返回值是否是泛型无关，根据类推导的规则，取两次不同使用的最大交集类型（最近共同父级）
        //Integer 和Float 的最近祖先类就是Number
        Number x=function1(1,1.2f);
        //情形二：类型推导
        Set<Integer> inters=new HashSet<>();
        Set<Double> doubles=new HashSet<>();
        //第一种写法  Set<Number>  result=FindTest.<Number>function2(inters,doubles);
        //第二种写法 Set<Number>  result=FindTest.function2(inters,doubles);
        Set<Number>  result=FindTest.<Number>function2(inters,doubles);

        //情形三：最简单的类型推导
        Integer  int1=new Integer(1);
        Integer  int2=new Integer(2);
        Integer int3=function3(int1,int2);

        //情形四：泛型构造函数,编译器根据传入的String类型，而推导出 泛型是String 类型
        new FindTest<Integer>("");

        //情形五：目标类型,经过编译器类型推导， 由于目标类型是Set<String>，所以现在我们会认为T 就是String
        Set<String> set1=function4();

        //目标类型是List<String> t1 ，所以 emptyList方法返回值就变成了 List<String>
         function5(Collections.emptyList());


    }
    public static <T> T  function1(T t1,T t2){

        return t1;
    }
    public static <T> Set<T>  function2(Set<? extends T> t1,Set<? extends T> t2){

         return null;
    }
    public static <T> T function3(T t1,T t2){

        return null;
    }

    public static <T> Set<T> function4(){

        return null;
    }
    public static  void function5(List<String> t1){

    }
}

