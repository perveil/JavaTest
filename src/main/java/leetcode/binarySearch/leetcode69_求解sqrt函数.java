package leetcode.binarySearch;
/*
* 求解sqrt(x)
* */
public class leetcode69_求解sqrt函数 {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left=2;      //左边界
        int right=x/2; //右边界,sqrt(num)<num/2
        int guess=0;
        while (left<=right){
            guess=(left+right)/2;
            if((long)guess*guess==x){
                return guess;
            }
            if ((long)guess*guess>x){
                right=guess-1;
            }else {
                left=guess+1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        new leetcode69_求解sqrt函数().mySqrt(2147395599);
    }
}
