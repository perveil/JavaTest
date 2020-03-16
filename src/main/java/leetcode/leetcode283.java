package leetcode;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        int num=0;
        int curindex=0;
        for (int i =0; i <nums.length; i++) {
            if (nums[i]==0){
                num++;
            }else {
                nums[curindex]=nums[i];
                curindex++;
            }
        }
        for (int i = nums.length-num; i <nums.length ; i++) {
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        new leetcode283().moveZeroes(new int[]{
                0,1,0,3,12
        });
    }
}
