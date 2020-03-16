package leetcode;
/*
* 暴力搜索会超时，思路转变为 寻找以每一个数组元素为最小值的子序列。
*
*
* */

public class leetcode907 {
    public static void main(String[] args) {
        System.out.println(
                sumSubarrayMins(new int[]{
                        3,1,2,4
                })
        );
    }
    public static int sumSubarrayMins(int[] A) {
        int target=1;
        int result=0;
        boolean flag=true;
        while(flag){
            for(int i=target-1,j=0;i<A.length&&j<A.length;j++,i=j+target-1){
                int min=A[j];
                for(int k=j;k<=i;k++){
                    if(min>A[k]) min=A[k];
                }
                result+=min;
                result%=1000000007;
            }
            if(target <A.length) target++;
            else break;
        }
        return result;
    }
}
