package leetcode;

public class leetcode215 {
    public static void main(String[] args) {
        new leetcode215().findKthLargest(new int[]{
                3,2,3,1,2,4,5,5,6
        },7);
    }
    public int findKthLargest(int[] nums, int k) {
        if(k<1) return 0;
        if (k==nums.length){
            int min=nums[0];
            for (int i = 0; i <nums.length ; i++) {
                if (min>nums[i]) min=nums[i];
            }
            return min;
        }
        KwidthArrayMin(nums,k);
        for(int i=k;i<nums.length;i++){
            if(nums[i]>nums[0]){
                swap(nums,0,i);
                KwidthArrayMin(nums,k);
            }
        }
        return nums[0];
    }
    public void KwidthArrayMin(int[] nums, int k) {
        int  min=nums[0];
        for(int i=1;i<k;i++){
            if(nums[i]<min){
                swap(nums,0,i);
                min=nums[0];
            }
        }
    }
    public void swap(int[] nums, int s,int e) {
        int temp=nums[s];
        nums[s]=nums[e];
        nums[e]=temp;
    }
}
