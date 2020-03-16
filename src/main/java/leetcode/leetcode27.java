package leetcode;

public class leetcode27 {
    public static void main(String[] args) {
        new leetcode27().removeElement(
                new int[]{
                        3,2,2,3
                },3
        );
    }
    public int removeElement(int[] nums, int val) {
        int result=nums.length;
        for(int i=0;i<result;i++){
            if(nums[i]==val){
                int removeindex=i;
                while(++removeindex<nums.length){
                    nums[removeindex-1]=nums[removeindex];
                }
                result--;
                if(i!=nums.length-1) i--;
            }
        }
        return result;
    }
}
