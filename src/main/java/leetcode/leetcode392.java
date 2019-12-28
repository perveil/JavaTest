package leetcode;

/*
* 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
* 思路 一：贪心法 时间复杂度 O(n*m)
*  例如 abcde 中的ace
*   a b c d e
* a 1
* c   0 1
* e       0 1       1的个数是ace的长度
*
*
* 思路 二： 动态规划
*   a b c d e
* a 1
* c   0 1
* e       0 1
*
*
*
 * */
public class leetcode392 {

    public static void main(String[] args) {


        System.out.println(
                isSubsequence("","")
        );
    }

    //贪心法
    public static boolean isSubsequence(String s, String t) {

        int length=s.length();  //结果
        char [] array1=s.toCharArray();
        char [] array2=t.toCharArray();
        if (array1.length==0){
           return true;
        }
        int i=0,j=0;
       while (i <array2.length&&j < array1.length) {
         if (array1[j]==array2[i]){
             i++;
             j++;
             length--; //递减s
         }else {
             i++;
         }
        }
        return length==0;

    }
    //dp
    public static boolean dpForisSubsequence(String s, String t) {
        boolean result[][]=new boolean[s.length()+1][t.length()+1]; //dp 表
        char [] array1=s.toCharArray();
        char [] array2=t.toCharArray();
        //初始化元素
//        for (int i = 0; i <array2.length ; i++) {
//            if (array2[i]==array1[0]){
//                 result [0][i]=true;
//            }
//        }
        for (int i = array2.length-1; i >=0 ; i--) {
            for (int j =array1.length-1; j >=0; j--) {
                if (array1[j]==array2[i]){
                }
            }
        }
        return false;

    }

}