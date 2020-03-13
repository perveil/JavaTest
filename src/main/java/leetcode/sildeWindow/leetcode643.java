package leetcode.sildeWindow;

public class leetcode643 {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int right=k-1;
        int sum=0;
        int cursum=0;
        for(int i=0;i<k;i++){
            cursum+=nums[i];
        }
        sum=cursum;
        while(right<nums.length){
            if(right+1<nums.length){
                cursum=cursum-nums[left]+nums[right+1];
                sum=Math.max(sum,cursum);
            }
            left++;
            right++; //窗口平移
        }
        return (sum*1.0)/k;
    }

    public static void main(String[] args) {
        new leetcode643().findMaxAverage(
                new int[]{
                        1,12,-5,-6,50,3
                },1
        );
    }
}
