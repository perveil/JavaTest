package leetcode.binarySearch;

public class leetcode153Or154 {
    /*
    * leetcode 153
    * */
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int mid=0;  //mid的一侧一定是有序序列
        /*
         * nums[right]<nums[mid] 左侧有序，最小值在右边
         * nums[mid]<nums[right] 右侧有序，此时左边出现最小值，但此时中值也可以是最小值
         *
         * */
        while(left<right){
            mid=(left+right)/2;
            if (nums[mid]>nums[right])
                left=mid+1;
            else if (nums[mid]<nums[right]){
                right=mid;
            } /*
             else
              right-- leetcode 154
            */


        }
        return nums[left];

    }

    public static void main(String[] args) {
        new leetcode153Or154().findMin(new int[]{
               4,0,1,2,3
        });
    }
}
