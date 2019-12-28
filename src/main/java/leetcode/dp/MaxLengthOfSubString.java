package leetcode.dp;
/*
*  题目一：请从一个字符串中找出最长的没有重复字母的子字符串的最长长度
*  思路一：动态规划：f(n) 是一个求 从第一个字符开始的长度为n的字符串的最大目标子串
*  f(n) 当第n个字符在之前没有出现过则：f(n)=f(n-1)+1;
*      当第n个字符在之前出现过：1. 相对上一个该字符所出现的位置的偏移量 m
*      如果 m>f(n-1) 则上一个该字符没有出现在f（n-1）的计算结果中 f(n)=f(n-1)
*      如果 m<f(n-1) 则上一个字符出现在f(n-1)所代表的目标字串，所以f（n）=m
*   思路二：
* */

public class MaxLengthOfSubString {
    public static void main(String[] args) {
        System.out.println(
                estSubString("GCCCTAGCCAGDE","GCGCCAGTGDE")
        );
    }

    public static String estSubString(String st1,String str2){
        if (st1.equals(str2)){
            return st1;
        }
        char [] array1=st1.toCharArray();
        char []  array2=str2.toCharArray();
        int result=0;
        int end=0;
        int [][]resultArray=new int [array1.length][array2.length];
        //初始化结果数组
        for (int i = 0; i < array1.length; i++) {
            if (array1[i]==array2[0]){
                resultArray[i][0]=1;
            }
        }
        for (int i = 0; i <array2.length ; i++) {
            if (array2[i]==array1[0]){
                resultArray[0][i] = 1;
            }
        }
        //dp 由于初始化函数会匹配公共子序列的头元素，所以从1开始dp
        for (int i = 1; i <array1.length ; i++) {
            for (int j = 1; j <array2.length ; j++) {
                if (array2[j]==array1[i]){
                    resultArray[i][j]=resultArray[i-1][j-1]+1;
                    if (resultArray[i][j]>result){
                        result=resultArray[i][j];
                        end=i;
                    }
                }
            }
        }

        return st1.substring(end-result+1,end+1);

    }
}
