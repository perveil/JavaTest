package ClassTest;

/*

 */
class test {
    public static final int n = 2; //加了final的时候 n的值在编译的时候就已经确定

    static {
        System.out.println("test");
        int x = 5; //局部变量
    }

    static int x, y; //类变量

    public static void Method() {
        y = x++ + ++x;
    }
}


public class StaticTest2 {
    public static void main(String[] args) {
        test x = new test();

        System.out.println(x.x++ + x.y);
        System.out.println(test.n);
    }

}
