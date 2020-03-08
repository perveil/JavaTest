package leetcode.binarySearch;

public class leetcode33 {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=(left+right)/2; //中点
        while(left<=right){
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]<=nums[mid]) //右边升序
            {
                if(target>=nums[left]&& target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1; //只能从右边找
                }
            }else{ //左边升序
                if(target>nums[mid]&& target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1; //只能从左边找
                }
            }
            mid=(left+right)/2;
        }
        return -1;  //没找到
    }
}
