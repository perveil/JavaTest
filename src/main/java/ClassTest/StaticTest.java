package ClassTest;

/*
 *  1.实例子类执行顺序：父类静态语句块->子类静态语句块->父类非静态属性初始化->父类构造函数->子类非静态属性初始化->子类构造函数
 *  2.private 修饰类变量=》static变量对于所有实例可见，所以private失效
 *  3.Static 语句块执行时间=》类加载过程的时机由虚拟机自由掌握
 *   主动引用触发初始化
 *    1.创建类的实例
 *    2.访问类的静态变量（除去常量）
 *    3.访问类的静态方法
 *    4.反射如(Class.forName("my.xyz.Test"))
 *    5.当初始化一个类时，发现其父类还未初始化，则先出发父类的初始化
 *    6.虚拟机启动时，定义了main()方法的那个类先初始化
 *   被动引用触发初始化
 *     1.子类引用父类类变量，子类不会被初始化，父类会被初始化
 *     2.通过数组定义来引用类，不会触发类的初始化
 * */
public class StaticTest {
    private static int x = 100; //经过static修饰，x是类变量，即对于所有的实例来说，访问的都是一个x，所以不可能是私有

    static {
        System.out.println("Hi");
    } //Only when the mian () method is excuted,静态语句块的执行时间是在加载类的时候便触发

    public void print() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        StaticTest staticTest = new StaticTest();
        staticTest.x++;

        new B();


    }
}

class A {
    static {
        System.out.println("AStatic");
    }

    private String At = "At";

    A() {
//       this.At();
        System.out.println("ACon");
    }

    public void At() {
        System.out.println(At);
    }

    public static void StaticMethod() {
        System.out.println("Static Method"); //而且子类无法调用父类的类方法
    }
}

class B extends A {
    static {
        System.out.println("BStatic");
    }

    public B() {
        super.At(); //观察父类非静态属性的加载顺序
        System.out.println("BCon");
    }


}

