package DataType;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer test = new StringBuffer(10).append("1234");
        //将容量赋值为10 ,但是当前长度只是“1234”.length
        System.out.println(test.capacity() + " " + test.length());
        //Length 返回当前长度
        //而capacity返回当前StringBuffer的容量，在容量可以在构造函数传参赋值，默认是16

        //StringBuffer的构造函数的传递参数，是StringBuffer的容量，默认是16
        //    public StringBuffer() {
        //        super(16);
        //    }
        //    public StringBuffer(int capacity) {
        //        super(capacity);
        //    }
        int x = 20;
        int y = 5;
        System.out.println(x + y + "" + (x + y) + y);
        // 优先级肯定是()最高，任何字符和字符串相加都是字符串，但是默认在 "" 的后边的处理全部按照字符串的方式
        //而在前面继续使用之前的处理方式

        StringBuffer replacePlace = new StringBuffer(" we are happy ");
        int position = 0;
        int NowPosition = 0;
        StringBuffer newBuffer = new StringBuffer();
        while (position <= replacePlace.length() - 1) {
            if (replacePlace.charAt(position) == ' ') {
                newBuffer.append(replacePlace.substring(NowPosition, position)).append("%20");
                NowPosition = position + 1;
            }
            position++;
            if (position == replacePlace.length() - 1 && replacePlace.charAt(position) != ' ') {
                newBuffer.append(replacePlace.substring(NowPosition));
            }
        }
        System.out.println(newBuffer);

        /*
         * 1.a-->"A"   b-->"B"
         * 2.X-->"A"   Y-->"B" a-->"A"   b-->"B"    a和X、Y和b 均指向同一个地址
         * 3.X-->"AB"  Y-->"AB" a-->"AB" b-->"B"  a和X和Y 均指向同一个地址
         * 引用类型传值、原始类型传值
         * 1.原始类型拷贝的是值，原始类型拷贝的本身由于只在栈内占内存，而不在堆中占内存，
         * 所以原始类型拷贝改变，本身并不会改变
         * 2，引用类型拷贝的是地址，引用类型的改变实际上是地址处的数据的改变，
         *   ps：引用类型的赋值，是引用指向地址的改变
         * */
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);


    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}
