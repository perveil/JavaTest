package ClassTest;

public class StaticTest {
    private static int x=100; //经过static修饰，x是类变量，即对于所有的实例来说，访问的都是一个x，所以不可能是私有
    static {
        System.out.println("Hi");
    } //Only when the mian () method is excuted,静态语句块的执行时间是在加载类的时候便触发
    public  void print()
    {
        System.out.println("Hello");
    }
    public static void main(String[] args) {
         StaticTest staticTest=new StaticTest();
         staticTest.x++;


        new B();
             //实例子类执行顺序：父类静态语句块->子类静态语句块->父类非静态属性初始化->父类构造函数->子类非静态属性初始化->子类构造函数
    }
}
class A{
   static {
       System.out.println("AStatic");
   }
   private String At="At";
   A(){
//       this.At();
       System.out.println("ACon");
   }
    public void  At(){
        System.out.println(At);
    }
    public static void  StaticMethod(){
        System.out.println("Static Method"); //而且子类无法调用父类的类方法
    }
}
class B extends A{
    static {
        System.out.println("BStatic");
    }
     public B(){
         super.At(); //观察父类非静态属性的加载顺序
         System.out.println("BCon");
    }
}

