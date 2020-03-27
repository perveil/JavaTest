package leetcode.traceBack;

public class leetcode494_目标和 {
    int res=0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length==0) return 0;
        helper(nums,0,S,0,nums.length-1);
        return res;
    }
    private  void helper(int[] nums,int cur,int S,int start,int end){
        if (start>end){
            if (cur==S){
                res++;
            }
            return;
        }
        helper(nums,cur+nums[start],S,start+1,end); //加
        helper(nums,cur-nums[start],S,start+1,end); //减
    }

    public static void main(String[] args) {
        new leetcode494_目标和().findTargetSumWays(new int[]{
                1,1,3,1,1
        },3);
    }
}
