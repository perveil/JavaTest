package enumt;

import java.util.HashMap;
import java.util.Map;

public enum Opreation  {
    PLUS("+"){ //枚举类型中的抽象方法必须被他所有的常量所实现
        // 构造函数 使得其与数据关联，实现抽象方法使得其与行为关联
        double apply()
        {
            return  0.1;
        }
    },
    MINUX("-"){
        double apply()
        {
            return  0.1;
        }
    },
    TIMES("/"){
        double apply()
        {
            return  0.1;
        }
    };
    private final  String symbol;
    /*
    * 使用静态方法，实现枚举与toString之间的映射
    *  类加载的顺序：static变量、static 静态语句块 --  其他成员变量  --  构造函数
    * */
    private static Map<String,Opreation> list=new HashMap<>();
    static {
        for (Opreation o: Opreation.values()) {
            list.put(o.toString(),o);
        }
    }
    public static Opreation formString(String symbol){
          return list.get(symbol);
    }

    Opreation(String symbol){
        this.symbol=symbol;
    }
    abstract  double apply();

    @Override
    public String toString() {
        return symbol;
    }
    /*
     * 每一个枚举都有一个ordinal()，表示常量在枚举列里边的索引值，从0 开始
     * 但是 永远都不要用这个序数来表示你的枚举常量之间的差异和常量的特定含义
     * 它是用来设计EnumSet 和EnumMap 这种基于枚举的通用数据结构
     * */
    public  int getNumber(){
        return ordinal()+1;
    }
}
