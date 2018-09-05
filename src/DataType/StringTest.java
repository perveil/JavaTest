package DataType;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * String  继承CharSequence接口，实现字符序列化的所有方法，包括：chartAt、length、subSquence、toString
 * */

public class StringTest {

    private static final String MESSAGE = "taobao";

    public static void main(String[] args) throws UnsupportedEncodingException {
        int a = '2'; //单引号是字符型，所有发生了char->int的转换
        //常见字符的ASCII码值如下：空格的ASCII码值为32；数字0到9的ASCII码值分别为48到57；
        // 大写字母“A”到“Z”的ASCII码值分别为65到90；
        // 小写字母“a”到“z”的ASCII码值分别为97到到122。

        // int n="2"; cannot cast String to Int
        System.out.println(a);

        String c = "tao" + "bao";
        System.out.println(c);
        System.out.println(c == MESSAGE);

        String s = null;
        // if (s!=null|s.length()>0);  java.lang.NullPointerException
        // if( (s==null) | (s.length()==0) )
        /**
         * || && 短路运算符 如果第一个条件可以决定表达式的正误时，就不再验证第二个表达式
         * //
         *
         */

        //实现GBK编码字节流到UTF-8编码字节流的转换
        byte[] str = {}, dst = {};
        dst = new String(str, "GBK").getBytes("UTF-8");
        /*
            public String(byte bytes[], String charsetName)throws UnsupportedEncodingException {
                 this(bytes, 0, bytes.length, charsetName);
        }
        * */
        // StringArray 初始化后数组的每一个元素初始化为Null
        String[] StrArray = new String[10];
        System.out.println(StrArray[0]);


        Pattern pattern = Pattern.compile("^\\d+\\w+");
        /* 根据正则表达式生成一个Pattern对象
        complie方法还接收另外一个参数：调整匹配的行为
        Pattern.CANON_EQ :完全规范相匹配
        Pattern.CASE_INSENSITIVE(?!) ： 取消对大小写的敏感
        Pattern.COMMENTS(?x) 忽略空格符o

        Pattern.DATALL(?s)  '.'将匹配所有的字符，包括“\n”，而在一般情景下，‘.’不能匹配‘\n’
        Pattern.MULTILINE(?m) 多行模式下，表达式^ $ 匹配每一行的开始和结束，单行模式下，整个字符串只匹配一处 ^ $[
        * */

        /*
        public Matcher matcher(CharSequence input) {
        if (!compiled) {
            synchronized(this) {
                if (!compiled)
                    compile();
            }
        }
        Matcher m = new Matcher(this, input);
        return m;
       }
        * */
        Matcher matcher = pattern.matcher("12java");

        System.out.println(matcher.find() + " start:" + matcher.start() + " end:" + matcher.end() + " " + matcher.matches() + " " + matcher.lookingAt());
        /*
        matcher.matches() matches 函数是在匹配 过程 中的验证方法，验证目标字符串是否从开始到结尾都符合条件
        matcher.lookingAt()函数是在匹配过程中只要开始的时候符合就可以了

        * */
        //12java


    }
}
