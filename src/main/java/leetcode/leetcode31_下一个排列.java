package leetcode;

/*
*
* */
public class leetcode31_下一个排列 {
    public static void main(String[] args) {
        new leetcode31_下一个排列().nextPermutation(
                new int[]{
                    1,2,7,4,3,1
                }
        );
    }
    public void nextPermutation(int[] nums) {
        if (nums.length==0) return;
        int len=nums.length;
        int i=len-1;
        while(i>0&&nums[i-1]>=nums[i]){  //找到尾部的逆序序列
            i--;
        }
        //旋转逆序数组
        for (int j = i; j <=(i+len-1)/2 ; j++) {
            int temp=nums[j];
            nums[j]=nums[(i+len-1)-j];
            nums[(i+len-1)-j]=temp;
        }
        if (i>0){
            for (int j = i; j <len ; j++) {
                if(nums[j]>nums[i-1]){
                    int temp=nums[i-1];
                    nums[i-1]=nums[j];
                    nums[j]=temp;
                    break;
                }

            }
        }

        
    }
}
