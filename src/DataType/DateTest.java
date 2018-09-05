package DataType;

import java.util.Date;

public class DateTest extends Date {
    private void test() {
        System.out.println(super.getClass().getName());
        //包名.类名，调用父类的getClass()，但是Date类并没有重写Object的getClass()方法，所以相当于调用Object对象的getClass方法，DataType.DateTest
       /*
        * @return The {@code Class} object that represents the runtime
        *         class of this object.
        public final native Class<?> getClass();
       *
       * */
        System.out.println(super.getClass().getSuperclass()); //class java.util.Date
    }

    public static void main(String[] args) {
        new DateTest().test();

    }
}
