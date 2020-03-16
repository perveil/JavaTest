package leetcode;

/*
* 解法一： 值优先匹配两个字符串中的某一个，一个大小为(m+n)的int数组，1代表和前者匹配，0代表不匹配
* 不匹配时，要和剩下的字符串的字符相比，如果不相同，则返回false
* 时间复杂度是 n
* 错误
*
* 解法二
* */

public class leetcode97 {
    public static void main(String[] args) {
          new leetcode97().isInterleave(
                  "aabcc",  "dbbca",  "aadbbcbcac"
          );
    }
    public boolean isInterleave(String s1, String s2, String s3) {
     int [] falg=new int[s1.length()+s2.length()]; //初始化为0
     int str1head=0;
     int str2head=0;





        return true;
    }
}
