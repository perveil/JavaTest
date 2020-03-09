package leetcode.binarySearch;

public class leetcode35 {
    public static void main(String[] args) {
       new leetcode35().searchInsert(
               new int[]{
                       1,2,3,5
               },4
       );
    }
    public int searchInsert(int[] nums, int target) {
        int result=0;
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){
            int md=(head+tail)/2;
            if(nums[md]==target){
                return md;
            }else if(nums[md]<target){
                head=md+1;
            }else{
                tail=md-1;
            }
        }
        return head;

    }


}
