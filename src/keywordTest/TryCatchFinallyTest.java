package keywordTest;

/*
 * try.catch.finally的执行顺序
 * 1.当try 中有return，且有finally语句块的时候，先执行finally语句块，相当于使用另一种方式把try的return先挂了起来
 * 2.finally语句是无论如何都要执行的，所以不管try或者catch有return，都先调用finally语句
 * */
public class TryCatchFinallyTest {
    public static void main(String[] args) throws Exception {
        System.out.println(f_test1());

        //  System.out.println(f_test2());
    }

    public static int f_test1() {
        int a = 0;
        try {
            System.out.println("try");
            a++;
            return a;
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }

        return a++;

    }

    public static int f_test2() throws Exception {
        int a = 0;
        try {
            System.out.println("try");
            a++;
            throw new Exception();
        } catch (Exception e) {
            a++;
            return a;
        } finally {
            System.out.println("finally");
            a++;
        }


    }
}
