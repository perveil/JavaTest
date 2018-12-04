package DataType;

public class TestLong {
    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3, b6, b8;
        final byte b4 = 4, b5 = 6, b7;
        //b3=(b1+b2); error
        b6 = b4 + b5;
        //b8=(b1+b4);   //error
        //b7=(b2+b5);   //error
        /*
        *java表达式转型规则由低到高转换
        * 所有byte、short、char被提升到int型
        *   1、所有的byte,short,char型的值将被提升为int型；
            2、如果有一个操作数是long型，计算结果是long型；
            3、如果有一个操作数是float型，计算结果是float型；
            4、如果有一个操作数是double型，计算结果是double型；
            最重要的是：
            final修饰的变量不会自动改变类型1
        *
        * */
    }
}
