package leetcode;

public class leetcode287 {
    public static void main(String[] args) {
      System.out.println(findDuplicate(new int[]{8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18}));
    }
    public static  int  findDuplicate(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[nums[i]-1]&&i!=nums[i]-1){
                result=nums[i];
                return result;
            }
            if(nums[i]==nums[nums[i]-1]&&i==nums[i]-1){
                continue;
            }
            if(nums[i]!=nums[nums[i]-1]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                if (i-1>=0){
                    i--;
                }
                continue;
            }
        }
        return result;
    }

}
