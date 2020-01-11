package leetcode;

public class leetcode80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int len=nums.length;
        int cur=nums[0];
        int cur_num=1;
        int result=1;
        for(int i=1;i<len;){
            if(i<len&&cur==nums[i]&&cur_num<2){
                cur_num++;
                result++;
                i++;
            }else  if(i<len&&cur==nums[i]&&cur_num==2){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                len--;
            }
            if(i<len&&cur!=nums[i]){
                cur=nums[i];
                cur_num=1;
                result++;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new leetcode80().removeDuplicates(new  int[]{
                0,0,1,1,1,1,2,3,3
        });
    }
}