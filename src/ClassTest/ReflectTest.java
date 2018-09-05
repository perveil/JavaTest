package ClassTest;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/*
 * 1.反射-》继承, “不可见”与“不继承”
 * 子类从其父类继承所有成员（字段，方法和嵌套类）。构造函数不是成员，所以它们不被子类继承，但是可以从子类调用超类的构造函数。
 * 但是父类私有成员子类的访问不到的原因是不可见，而不是不继承
 * */
class Parent {
    Parent() {
        System.out.println("调用父类构造方法!");
    }

    private static void staticParent() {
        System.out.println("调用父类静态方法");
    }

    private final void finalParent() {
        System.out.println("调用父类final方法");
    }

    private void printParent() {
        System.out.println("调用父类私有方法");
    }

    public void publicParent() {
        System.out.println("调用父类私有方法");
    }
}

class Child extends Parent {
    public void printChild() {
        System.out.println("调用子类公有方法");
    }
}

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class child = Class.forName("ClassTest.Child");
        Class father = child.getSuperclass(); //拿到父类
        Method[] methods = father.getDeclaredMethods();
        /*
        getMethods():该方法是获取本类以及父类或者父接口的所有公共（public）的方法
        getDeclaredMethods():获取本类以及父类或者父接口的所有方法（private、public、protected）
        getFileds()与getDeclaredFileds() 类似
        */
        AccessibleObject.setAccessible(methods, true);
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
