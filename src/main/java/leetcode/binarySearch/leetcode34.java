package leetcode.binarySearch;

public class leetcode34 {
    public static void main(String[] args) {
        new leetcode34().searchRange(
                new int[]{
                        1
                },1
        );
    }
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[2];
        result[0]=result[1]=-1;
        int head=0;
        int tail=nums.length-1;
        while(head<=tail){
            int md=(head+tail)/2;
            if(target==nums[md]){
                result[0]=result[1]=md;
                int before=md;
                int after=md;
                while(--before>-1&&nums[before]==target){}
                result[0]=before+1;
                while(++after<nums.length&&nums[after]==target){}
                result[1]=after-1;
                break;
            }else if(target>nums[md]){
                head=md+1;
            }else{
                tail=md-1;
            }
        }
        return result;

    }
}
