package ClassTest;
class test{
    public static final int n = 2; //加了final的时候 n的值在编译的时候就已经确定
    static{
      System.out.println("test");
    }
}

/*
 java 主动使用类的情况
   1.创建类的实例
   2.访问某个类或接口的静态变量或
   3.反射
   4.初始化子类的时候
   5.启动类
* */
public class StaticTest2 {
    public static void main(String[] args) {
         System.out.println(test.n);
    }

}
