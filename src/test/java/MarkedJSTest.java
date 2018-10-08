import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkedJSTest {
    @Test
    public String  getFileName(){
        File file = new File("C:\\Users\\Administrator\\Desktop\\文件\\文件\\java笔记\\java设计模式\\建造者模式builder.md");
        String Result []=file.getName().split("[^a-zA-Z]+");
        return Result[2]+"Result";
    }
}
