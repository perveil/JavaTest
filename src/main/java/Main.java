import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    /*
     * 1.java 字节码是java源文件编译产生的中间文件
     * java虚拟机是可运行java字节码的假象计算机
     * java源程序-》(经过编译)字节码(Byte Code)->机器码
     * */
    public static void main(String[] args) throws ParseException {
//        Calendar calendar=Calendar.getInstance();
//        String data="2018-10-11";
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//        calendar.setTime(format.parse(data));
//        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        String remain="123";
        System.out.println(
           remain.substring(0,0)+remain.substring(1)
        );

    }
}
