package leetcode;
/*
  @Date:2020/4/15 9:56
  @Author:Administrator
*/

import java.util.*;

public class leetcode29_两数相除 {
    /*
    * 非移位，递归解法
    * */
    public int divide(int dividend, int divisor) {
        if (dividend==0) return 0;
        if (divisor==1) return dividend;
        if (divisor==-1) {
            if (dividend>Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }
        long a=dividend;
        long b=divisor;
        int sign=((a>0&&b<0) || (a<0&&b>0))?-1:1; //符号
        a=a<0?-a:a;
        b=b<0?-b:b;
        long res=divhelper(a,b);
        if (sign>0) return (int) (res>Integer.MAX_VALUE?Integer.MAX_VALUE:res);
        return (int)-res;
    }
    int divhelper(long a ,long b){
        if (a<b) return 0;
        int count=1;
        long tb = b;
        while(a>(tb+tb)){
            count=count<<1;
            tb=tb<<1;
        }
        return count+divhelper(a-tb,b);
       //divhelper(a-tb,b) 此时剩余的数 a-tb,递归求解
    }
}
