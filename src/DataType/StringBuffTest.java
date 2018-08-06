package DataType;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StringBuffTest {
    public static void main(String[] args) {
        StringBuffer test=new StringBuffer(10).append("1234");
        //将容量赋值为10 ,但是当前长度只是“1234”.length
        System.out.println(test.capacity()+" "+test.length());
        //Length 返回当前长度
        //而capacity返回当前StringBuffer的容量，在容量可以在构造函数传参赋值，默认是16

        //StringBuffer的构造函数的传递参数，是StringBuffer的容量，默认是16
        //    public StringBuffer() {
        //        super(16);
        //    }
        //    public StringBuffer(int capacity) {
        //        super(capacity);
        //    }
        int x=20;
        int y=5;
        System.out.println(x+y +""+(x+y)+y);
        // 优先级肯定是()最高，任何字符和字符串相加都是字符串，但是默认在 "" 的后边的处理全部按照字符串的方式
        //而在前面继续使用之前的处理方式

        StringBuffer replacePlace= new StringBuffer(" we are happy ");
        int position=0;
        int NowPosition=0;
        StringBuffer newBuffer=new StringBuffer();
        while (position<=replacePlace.length()-1){
            if (replacePlace.charAt(position)==' '){
                newBuffer.append(replacePlace.substring(NowPosition,position)).append("%20");
                NowPosition=position+1;
            }
            position++;
            if(position==replacePlace.length()-1&&replacePlace.charAt(position)!=' '){
                newBuffer.append(replacePlace.substring(NowPosition));
            }
        }
        System.out.println(newBuffer);

    }
}
