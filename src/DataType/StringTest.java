package DataType;

public class StringTest {

    private static final String MESSAGE="taobao";
    public static void main(String[] args) {
      int a='2'; //单引号是字符型，所有发生了char->int的转换
        //常见字符的ASCII码值如下：空格的ASCII码值为32；数字0到9的ASCII码值分别为48到57；
        // 大写字母“A”到“Z”的ASCII码值分别为65到90；
        // 小写字母“a”到“z”的ASCII码值分别为97到到122。

       // int n="2"; cannot cast String to Int
      System.out.println(a);

        String c ="tao"+"bao";
        System.out.println(c);
        System.out.println(c==MESSAGE);

        String s=null;
       // if (s!=null|s.length()>0);  java.lang.NullPointerException
       // if( (s==null) | (s.length()==0) )
        /**
         * || && 短路运算符 如果第一个条件可以决定表达式的正误时，就不再验证第二个表达式
         * //
         *
         */



    }
}
