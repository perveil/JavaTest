package leetcode;

public class leetcode930 {
    public static void main(String[] args) {
        new leetcode930().numSubarraysWithSum(new int[]{
                1,0,1,0,1
        },2);
    }
    public int numSubarraysWithSum(int[] A, int S) {
        int result=0;
        for (int i = 0; i <A.length; i++) {
            for (int j = i; j <A.length ; j++) {
                if (SumOfNum(A,i,j)==S){
                    result++;
                    continue;
                }else if (SumOfNum(A,i,j)>S){
                    break;
                }else {
                    continue;
                }

            }
        }
        return result;
    }
    public int SumOfNum(int[] A,int start,int end){
        int sum=0;
        for (int i = start; i <=end ; i++) {
            sum+=A[i];
        }
        return sum;
    }
}
