package leetcode.binarySearch;
/*
* 判断一个数是否是一个完全平方数 sqrt(x)==整数
*
* */
public class leetcode367_验证是否是完全平方数 {
    public boolean isPerfectSquare(int num) {
        if(num<2) return true;
        long left=2;      //左边界
        long right=num/2; //右边界,sqrt(num)<num/2
        long guess=0;
        while (left<=right){
            guess=(left+right)/2;
            if(guess*guess==num){
                return true;
            }
            if (guess*guess>num){
                right=guess-1;
            }else {
                left=guess+1;
            }
        }
        return false;
    }
}
