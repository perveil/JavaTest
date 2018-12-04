package keywordTest;

public class TryCatch {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
            //finally不会忽略catch块里的return，但是会搁置，因为Finally是无论如何都要执行的
        }
        output += "4";
    }

    public static void main(String[] args) {
        foo(0);
        foo(1);
        System.out.println(output);
    }
}
