package ClassTest;

class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

/*
 *详解类加载过程
 * */
public class ClassLoadTest {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        //调用类的静态方法，触发类的初始化过程，加载->验证->准备
        /*
         *准备阶段为类的静态变量分配内存并将其初始化为0或者null，准备阶段不分配类中的实例变量的内存
         * */
        /*
        准备->解析->初始化
        初始化阶段是执行类构造器<clinit>()方法的过程。
        <clinit>()方法方法是由编译器自动收集类中的所有类变量的赋值动作
        和静态语句块(static{}块)中的语句合并产生的。
        * */
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
