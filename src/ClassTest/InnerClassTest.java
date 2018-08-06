package ClassTest;
class Circle{
    double radius=0;
    public Circle(double radius){
        this.radius=radius;
    }
    static  class StaticClass{
        public StaticClass(){
          //System.out.println(radius); 内部静态类无法访问外部类的非Static成员
        }

    }

    class Draw{  //成员内部类可以无条件的访问外部类的所有变量和方法，包括私有和静态
        //但是外部类如果想访问内部类的时候，必须使用一个内部类的实例
        /*
        可以访问的原因是：经过反编译，内部类保持一个指针，指向外部类
        而且在内部类的构造函数中会传入一个外部类的参数:故内部是依附外部类存在的
        内部类一般不用于继承，如果要继承的话就必须，提供一个外部类作为参数的构造函数

        * */
        public void DrawSape(){
            System.out.println("innershape"+radius);
            int a=1;
            class MethodClass{
                //局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别
                //在于局部内部类的访问仅限于方法内或者该作用域内
                public MethodClass(){
                    System.out.println("局部内部类");
                    System.out.println(a);  //局部内部类对局部变量的是否是静态变量的访问？？？？
                }
            }
        }
        public Draw(){

        }
    }
}


public class InnerClassTest {
    public static void main(String[] args) {
        Circle circle=new Circle(1.1);
        //内部类依附外部类存在的，内部类存在的前提是外部类的存在
        Circle.Draw draw=circle.new Draw();
    }
}
