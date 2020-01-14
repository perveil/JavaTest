package leetcode.dp;


public class leetcode1027 {
    /*
    *  1.  贪心法 i<j d=A[j]-A[i] 依据d j<k 向后遍历
    *  2.  dp 空间换时间 一维dp失败 --》dp[i][d]  以d为公差、以A[i] 为末尾的等差数列的MAX length
    * */
    public int longestArithSeqLength(int[] A) {
        if(A == null || A.length < 3)
            return 0;
        int len=A.length;
        int[][] dp = new int[len][20001]; //20001为题目给的最大数据集数
        int result=0;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++) {
                int distance = A[i] - A[j] + 10000; //10000 是题目给的最大整数，因为公差可能是负数,故进行转换
                if (dp[j][distance]>0){
                    dp[i][distance]=Math.max(dp[i][distance],dp[j][distance]+1);
                }else{
                    dp[i][distance]=2; // i=1时 进行初始化dp数组，前两个数字肯定组成一个等差数组
                }
                result=Math.max(result,dp[i][distance]);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        new leetcode1027().longestArithSeqLength(new int[]{
                9,4,7,2,10
        });
    }
}
