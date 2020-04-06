package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode448_找到所有数组中消失的数字 {
    /*
    * 利用nums 数组的数组下标i+1
    * 没有辅助数组
    * O(1) 空间
    * O(n^(1.5))
    * */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=nums[nums[i]-1]){
                //nums[i] 不在 nums[nums[i]-1]位置上，所以交换位置
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                i=Math.min(nums[i]-1,i)-1; //接下来的起始位置取刚刚交换完的较小值
            }
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode448_找到所有数组中消失的数字().findDisappearedNumbers(
              new int[]{
                      4,3,2,7,8,2,3,1
              }
        );
    }
}
