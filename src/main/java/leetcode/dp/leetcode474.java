package leetcode.dp;

public class leetcode474 {
    /*
    *    变相背包问题,同一个字符串不能装入两次
    *    "0" "1" 必定优先装入
    * */
    public int findMaxForm(String[] strs, int m, int n) {

        /*
        * 同一个字符串可能被装两次
        * */
//      for (int i = 0; i <=m ; i++) {
//            for (int j = 0; j <=n; j++) {
//                for (int k = 0; k < nums.length; k++) {
//                    if (i-nums[k][0]>=0&&j-nums[k][1]>=0){
//                        dp[i][j]=Math.max(dp[i][j],dp[i-nums[k][0]][j-nums[k][1]]+1); //同一个字符串装了两次
//                    }
//                }
//            }
//        }

        /*
        * 此时字符串不能被装两次
        * */

        int [][]dp=new int[m+1][n+1]; //dp[i][j] i个0&&j个1最多可以组成的字符串个数
        for (String str:strs) {
            int []counts=countZorO(str);
            for (int zeroes=m;zeroes>=counts[0];zeroes--){
                for (int ones = n; ones >= counts[1]; ones--){
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - counts[0]][ones - counts[1]], dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];
    }
    /*
      统计字符串中出现的"0" 和"1"的个数
     */
    public int[] countZorO(String str) {
        char [] chars=str.toCharArray();
        int[] result=new int[2];
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='0') result[0]++;
            else result[1]++;
        }
        return result;
    }

    public static void main(String[] args) {
        new leetcode474().findMaxForm(new String[]{
                "10", "0", "1"
        },1,1);
    }
}
