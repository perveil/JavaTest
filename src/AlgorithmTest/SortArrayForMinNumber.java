package AlgorithmTest;

/*题目一：
* 输入一个正整数数组，把所有的整数连接在一起之后，比较其大小，并且输出连接之后的最小值
* 例如:
* {12,4,3} ==>1234
* 思路如下：
* 自定义一种排序方式，经过排序，然后得出一个定义下“有序的”数组，最后连接起来
*
* 题目二：
* 1-n的整数中寻找出现1的次数
* 1-11 =》4
*思路：https://www.cnblogs.com/qiaojushuang/p/7780445.html
* 当时第一次的看的时候毫无思绪，上面的博文是用py写的，也没简单多少
* 例如：36792
* 分为 1-9999 10000-19999(特殊处理) 20000-29999 30000-36792
* 6792第二次作为递归的对象向下查询
*     f(1) = 1   一位数
      f(2) = 9 * f(1) + 10 ** 1
      f(3) = 9 * f(2) + 10 ** 2
      f(n) = 9 * f(n-1) + 10 ** (n-1)  n位数
* 题目三：
* 数字以01234567891011121314.....m的格式序列化到一个字符序列在这个序列中第n位的数字是什么
*   0               1
* 1-9  字符串的长度  9
* 10-99            90*2
* 100-999          900*3
* f(n)=9*Math.pow(10,i)+f(n-1); 当最后的数是n位数时，最多有多长的字符串
*/


import java.util.Arrays;
import java.util.Comparator;

public class SortArrayForMinNumber {
    public static void main(String[] args) {
   //   toResult();
    //  System.out.println( toResultToSecond(9923446));
      toResultTothrid(11,12);
    }
    public static void toResult(){
        Integer aimArray[]={12,42,13};
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer num1=(Integer) o1;
                Integer num2=(Integer) o2;
                String temp1= ""+o1.toString()+o2.toString();
                String temp2= ""+o2.toString()+o1.toString();
                return temp1.compareTo(temp2);
            }
        };
        Arrays.sort(aimArray,comparator);
      String result="";
      for (int i=0;i<aimArray.length;i++){
          result+=aimArray[i].toString();
      }
      System.out.print(result);


    }
    public static int toResultToSecond(int n){
        if (n<10){
            if (n<=0) return 0;
            else return 1;

        }
        int digit =new String(""+n).length(); // 求出位数
        int low_nums=get_1_digit(digit-1);
        int high_nums=0,All_nums=0;
        int high=Integer.parseInt(new String(""+n).substring(0,1));
        int low= (int) (n-high*Math.pow(10,digit-1));

        if (high==1){
             high_nums=low+1;
             All_nums=high_nums;
        }else {
            high_nums=(int)Math.pow(10,digit-1);
            All_nums=high_nums+low_nums*(high-1);
        }
        return low_nums+All_nums+toResultToSecond(low);

    }
    public static int get_1_digit(int n){
           if (n<=0){
               return 0;
           }
           if (n==1){
               return 1;
           }
           int current= (int) (9*get_1_digit(n-1)+Math.pow(10,n-1));
           return current+get_1_digit(n-1);

    }
    /*
    * 如果返回的是-1 说明没找到
    * */
    public static void toResultTothrid(int m,int n){
        int digit=new String(""+m).length();
        if (digit==1){
            System.out.println(n-1);
        }
        int sum=1;
        for (int i=1;i<=digit;i++){
            sum+=(int)i*Math.pow(10,i-1)*9;
            if (sum>=n){
                sum-=(int)i*Math.pow(10,i-1)*9;
                n-=sum;
                System.out.print(new String(""+Math.pow(10,i-1)+n/i).toCharArray()[n-1]);
            }

        }

    }
}
