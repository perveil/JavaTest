package DataType;

import java.util.EnumMap;
import java.util.EnumSet;

/*
  enum的语法结构和class不一样
* 所有的枚举都继承自java.lang.Enum类
* 枚举实例都是一个final、static类的对象,比较枚举实例就直接可以使用==
* 不需要用equals方法
* */
enum Result {
    PASSWORD_UNCORRECT(-1, "密码不正确"),
    UNEXITUSER(-2, "用户不存在");

    private int code;
    private String msg;

    Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String toString() {

        return this.code + "-" + this.msg;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Result.PASSWORD_UNCORRECT);
        //values()方法 获得枚举类的所有实例，values() 是编译器插入到enum定义中的static方法，
        //所以在Enum类里边是没有values方法的
        Result[] results = Result.values();
        Enum EnumTest2 = Result.PASSWORD_UNCORRECT; //向上转型
        // EnumTest2).values(); 失效

        //name()方法
        System.out.println(Result.UNEXITUSER.name());

        //ordinal()方法 获得枚举的枚举实例的位置，从0开始
        System.out.println(Result.PASSWORD_UNCORRECT.ordinal());

        //实现了Comparable接口：比较的是枚举实例的顺序大小，从0开始
        System.out.println(Result.UNEXITUSER.compareTo(Result.PASSWORD_UNCORRECT));

        //switch()参数可以使用enum

        //EnumMap
        EnumMap<Result, String> resultEnumMap = new EnumMap<Result, String>(Result.class);
        resultEnumMap.put(Result.PASSWORD_UNCORRECT, "密码问题");
        resultEnumMap.put(Result.UNEXITUSER, "账户问题");
        //EnumSet
        EnumSet<Result> resultEnumSet = EnumSet.allOf(Result.class);
        for (Result result : resultEnumSet) {
            System.out.println(result);
        }

    }

}

//使用接口拓展枚举类
interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
}
