package DataType;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class TestLongForInteger {
    public static void main(String[] args) {
        Integer s = new Integer(9);
        Integer t = new Integer(9);
        Long s1 = new Long(9);
        System.out.println(s.equals(t));  //true
        System.out.println(s == t);  //false
        //    System.out.println(s1==t);  //编译不通过
        System.out.println(s1.equals(s)); //false

        //Long equals函数

//        public boolean equals(Object obj) {
//            if (obj instanceof Long) {
//                return value == ((Long)obj).longValue();
//            }
//            return false;
//        }
        /**
         * 整数型的默认为int 类型
         * 带小数的默认为double类型 ，因为double类型的数据比float数据类型的精度高
         */


        Integer i = 42;
        Long L = 42L;
        // System.out.println(i==L); 编译出错 ==相等的前提是数据类型相同


        int x = 3;
        int y = 1;
//        if (x=y){  //编译错误
//            System.out.println("s");
//        }
        /*
         *Java中，赋值是有返回值的 ，赋什么值，就返回什么值。比如这题，x=y，返回y的值，所以括号里的值是1。
         *Java跟C的区别，C中赋值后会与0进行比较，如果大于0，就认为是true；而Java不会与0比较，而是直接把赋值后的结果放入括号。
         */
        System.out.println(x = y);  //1
        float f = 42.0f;
        long l = 42;
        System.out.println(f == l);
        //float long 进行数制转换-》int

        //算数执行顺序
        System.out.println(10 % 2 * 1);  //% 和 * 优先级相同 从左向右执行


    }
}
