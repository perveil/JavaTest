package AlgorithmTest;



import java.util.Arrays;

/*
* 题目一：01背包问题：给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 w[i]，其价值为 v[i] ,求在给定最大容量的前提下，
* 能获取的最大的价值是多少？
*
* 使用的是动态规划的思想：对于每一个物品，我么只有两种选择，一个是装，一个是不装
* 装与不装先要进行判断：
* 1.因为在满足容量（不超过所给定的容量时）的前提下，装了之后大于不装的价值，则装，
* 如果小于，则不装
* 2.不满足容量问题时，当然不能装
* 那么问题就转化到了求不装之前的价值大小的问题：
*  result 是一个结果一维数组 元素初始化为0
*  f() 是一个通过背包容量计算所能容纳的最大价值的函数
*   if(容量满足){
*     if（f(n)<f(n-w[i])+v[i]）
*        f(n)=f(n-w[i])+v[i]
*   }
*
*第一次去看这个是很费劲，但是多看几次就看懂了
* */
public class PakageMaxValue {
    public static void main(String[] args) {
           pakageMaxValue();
    }
    public static void pakageMaxValue(){
       int MaxCap= 15;
       int productNum=5;
       int value[]={4, 5, 10, 11, 13};
       int cap[]={3, 4, 7, 8, 9};
       int result[] = new int[16];
        for (int i=0;i<MaxCap;i++) {
            result[i]=0;
        }
        for (int i=0;i<productNum;i++) {
            /*
            * i=0的时候给result赋初值，把能装下第一个物品的容量的value值全部赋值为这个物品的value
            * 接下来在装其他物品的时候就会替换
            * 比如装第二个物品的时候
            * 在容量允许的条件下：
            * 装了第二个和 只装了第一个或 只什么都没有装 之间发生比较
            *
            * 由于第一次的初始化在结果中就出现了第一个物品的value值
            * 所以在容量允许的条件下
            * 就会出现 同时装了第一个和第二个物品
            * 装第三个物品的时候：
            *由于Result出现过只有第二个物品、只有第一个物品、同时有第二和第三个物品的情况
            *
            * 依次类推
            *
            * */

            for (int j=MaxCap;j>cap[i];j--) {
                result[j] = Math.max(result[j], result[j - cap[i]] + value[i]);
            }
            /*
            * 最好是每一次把result数组打印出来观察一下
            * */
        }
        Arrays.sort(result);
        System.out.println(result[result.length-1]);

    }

}
