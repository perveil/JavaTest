package AlgorithmTest;
/*
* 题目一:输入一个二进制，输出这个数的二进制中1的个数
* 例如：9 1001    =>2
* 思路：位运算最简单的一道题：需要把数字每次向右移动一个单位，直到其变成0
* 但是当你输入一个负数的时候就会出现死循环的错误：
* 因为：
*
下面对位运算做个复习：

&：按位与
|：按位或
~：按位非 一元运算符
^：按位异或   对应位相同则为0，不同则为1
<<：左位移运算符  低位补0，二进制位向右移动    截断溢出
>>：右位移运算符  为正数时，高位补0，负数时，高位补1求其补码，再经补码求其源码
<<<：无符号右移运算符
  1.无符号的意思是将符号位当作数字位看待
  2.-1>>>1 ==MAX_Value
  3,低位溢出，高位补0
*
*
* 题目二：输出两个整数 n、m, m想变成n需要改变的位数
* 1001 1100 --》2
* 思路：异或运算符、寻找异或之后的1的个数
*
* 题目三：用一条语句判断一个数是不是2的整数次方
* 一个整数如果是2 的整数次方，那么他在化为二进制数之后只有一个1
*  (n-1)&n ==0
*  详情请看findOneNumber3 上的注释
* */
public class BinaryNumber {
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(2<<1));

        findOneNumber3(-1);
    }
    /*
    只能去找正数，不能找负数
    * */
    public static void findOneNumber(int n){
        int count=0;
        while(n!=0){
            if ( Integer.toBinaryString(n).toCharArray()[Integer.toBinaryString(n).length()-1]=='1'){
                count++;
            }
            n=n>>1;
        }
        System.out.println(count);
    }
    /*
     既能去找正数，又能找负数]
     n&flag 位取与
     110001 & 1000
     1000高位填充：001000
     110001 &001000 =》000000 两个数对应位有0 & 后结果对应位就是0
     Integer.toBinaryString(9&(2<<1))  1001
     n|flag  有1 则1
      Integer.toBinaryString(9|(2<<1))  1101
    * */
    public static void findOneNumber2(int n){
        int count=n<0?1:0;
        int flag=1;
        String maxString="10000000000000000000000000000000";
        while(Integer.toBinaryString(flag).compareTo(maxString)!=0){
              if (Integer.toBinaryString(n&flag).toCharArray()[0]=='1')
                  count++;
              flag=flag<<1;
        }
        System.out.println(count);

    }
    /*
    * 二进制的计算最佳优化 n-1 & n
    * 最后一位是1 的话 n-1之后 最右边的位归0
    * 最后一位为0 的话 n-1之后 最右边的1归0 ，其右边的0全部变成1 左边不变 例如 1100-1==12-1 1011
    * n $ n-1 可以使最右边的1变成0  例如 1100 & 1011 =1000
    * 所以优化的目的就是有几个操作几次，知道 n==0时结束循环
    * */
    public static  void findOneNumber3(int n){
       int count=0;
       while(n!=0){
           count++;
           n=(n-1)&n; // 优化的最重要的一步
       }
        System.out.println(count);
    }


}
