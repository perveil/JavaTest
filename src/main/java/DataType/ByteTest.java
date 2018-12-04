package DataType;
/*
 *
 *
 *
 * */

public class ByteTest {
    public static void main(String[] args) {
        //1
        short a = 128;
        byte b = (byte) a; //-128
        System.out.println(b);

        /*
         java int 128转为byte，值：128为正数，补码为10000000（前面24个0省略），
         变成byte，只剩下10000000（byte为1个字节），因为开头是1，所以为负数。
         即1个负数的补码是10000000。反码是01111111，原码是1000000。是128.因为是负数，所以是-128。
        */
    }
}
