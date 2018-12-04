package ClassTest;

import java.util.List;

/*
 * java 发生向上或者向下转型，编译看左边，运行看右边
 * 向上转型不必强制转化，向下转型必须强制转化，子类的特有属性被隐藏
 *
 * 运行时多态：
 * 1.实例方法与引用变量所引用的对象的方法绑定
 * 2.静态方法与引用变量所声明的类型的方法绑定
 * 3.成员变量（实例变量、静态变量）与引用变量所声明的类型的成员变量绑定
 * */
class Atest {
}

class Btest extends Atest {
}

public class UpcastingTest {
    public static void main(String[] args) {

    }
}
