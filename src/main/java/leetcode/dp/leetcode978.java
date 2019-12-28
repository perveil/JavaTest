package leetcode.dp;

public class leetcode978 {
    public static void main(String[] args) {
        new leetcode978().maxTurbulenceSize(new int[]{
                8,8,9,10,6,8,2,4,2,2,10,6,6,10,10,2,3,5,1,2,10,4,2,0,9,4,9,3,0,6,3,2,3,10,10,6,4,6,4,4,2,5,1,4,1,1,9,8,9,5,3,5,5,4,5,5,6,5,3,3,7,2,0,10,9,7,7,3,5,1,0,9,6,3,1,3,4,4,3,6,3,2,1,4,10,2,3,4,4,3,6,7,6,2,1,7,0,6,8,10
        });
    }

    //状态转换： 大于 1 等于 0 小于 -1
    public int maxTurbulenceSize(int[] A) {
        if (A.length==1){return 1;}
        int [] resultArray=new int[A.length-1];
        for (int i = 0; i <A.length ; i++) {
            if (i+1<A.length){
                if (A[i]>A[i+1]){
                    resultArray[i]=1;
                }else if (A[i]<A[i+1]){
                    resultArray[i]=-1;
                }else if (A[i]==A[i+1]){
                    resultArray[i]=0;
                }
            }
        }
        int [] dp=new int[A.length-1];  //表示以当前数字为尾部的目标序列
        dp[0]=0;
        int max=dp[0];
        for (int i = 1; i <resultArray.length ; i++) {
            int j=i-1;
            for (; j >0 ; --j) {
                if (resultArray[j]*resultArray[j-1]==-1){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                    max=dp[i];
                }else{
                    break;
                }
            }
        }
        System.out.println(max+2);
        return max+2;
    }
}
