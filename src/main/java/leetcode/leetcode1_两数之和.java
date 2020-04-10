package leetcode;
/*
* 查找有序数组的中位数
* */
public class leetcode1_两数之和 {
    public int[] twoSum(int[] numbers, int target) {
        int [] nums=new int[2];
        int start=0,end=numbers.length-1;
        while(start<end){
            if(target==numbers[start]+numbers[end]){
                nums[0]=start+1;
                nums[1]=end+1;
                break;
            }else if(target>numbers[start]+numbers[end]){
                start++;
            }else{
                end--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums=new int[]{
                2, 7, 11, 15
        };
        new leetcode1_两数之和().twoSum(nums,9);
    }
}
