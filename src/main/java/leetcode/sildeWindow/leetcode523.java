package leetcode.sildeWindow;

public class leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        for (int i = 0; i <nums.length; i++) {
            sum+=nums[i];
        }
        if (k==0&&sum==0){
            return true;
        }else if (k==0&&sum!=0){
            return false;
        }
        int left=0;
        int right=nums.length-1;
        while(left<right){

            //left+1、right-1分别尝试下
            if (sum%k==0||(sum-nums[left])%6==0||(sum-nums[right])%6==0)
                return true;
            sum=sum-nums[left]-nums[right];
            left++;
            right--;
        }
        return false;
    }

    public static void main(String[] args) {
        new leetcode523().checkSubarraySum(new int[]{
                23,2,4,6,7
        },6);
    }
}
