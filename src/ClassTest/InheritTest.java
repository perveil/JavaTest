package ClassTest;

class Person {
    String name = "No name";

    public Person(String nm) {
        name = nm;
    }
}

class Employee extends Person {
    String empID = "0000";

    public Employee(String id) {
        super("rui");
        /*
          父类构造方法在没有任何构造函数的时候，默认提供一个无参构造函数，当有了其他的构造函数时，默认的无参构造函数消失，
          在生成子类实例的过程中，需要向上先生成父类的实例，而此时没有父类无参构造函数，所以调用super() 编译错误，
          只能调用super("asd")
         */
        empID = id;
    }
}

public class InheritTest {
    public static void main(String[] args) {
        Employee e = new Employee("123");
    }
}
