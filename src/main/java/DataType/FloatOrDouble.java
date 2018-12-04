package DataType;

import java.math.BigDecimal;

/*
*对于精确的计算务必不要使用 double float
* 可以使用BigDecimal 或者 int 与long
* */
public class FloatOrDouble {
    public static void main(String[] args) {
        System.out.println((0.9+0.001)*100.0);  //1
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.004"))); //2
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.004)));//3
        System.out.println((0.9*100+0.001*100)); //4


    }
}
