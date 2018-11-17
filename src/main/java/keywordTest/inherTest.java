package keywordTest;

import java.lang.reflect.Field;
import java.util.Vector;
/*
* 可访问、可继承 两者的区别
*
* */

class son extends father{
    final int num; //空白Final 域，可以不赋初值，但是必须在每一个构造方法里边初始化
    son(){
        num=1;
    }
}
class father{
    private  String a="1";
    public  void println(){
        System.out.println(a);
    }
}

public class inherTest {
    public static void main(String[] args) {
        Field[] fields = son.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            System.out.println(fieldName);
        }
        son TheSon=new son();
        TheSon.println();
    }
}
