package DataType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\w+").matcher("wtf wtf wewe");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        int i = 0;
        /*
        find(index) 可以指定匹配开始的位置
        */
//        while (matcher.find(i)){
//            System.out.println(matcher.group());
//            i++;
//        }

    }
}
