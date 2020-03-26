package leetcode;

public class leetcode581_最短无序子数组 {
    /*
    * 暴力：
    *  0-(n-2) 遍历 nums[i] 向后遍历 i<j<n
    * 如果存在nums[i]>nums[j] 则说明nums[i]、nums[j] 都不在正确位置
    * 则找最小的i，最大的j，可求得最短的无序子数组
    *
    * */
    public int findUnsortedSubarray(int[] nums) {
        int l=nums.length,r=0; //初始化l为最大，r为最小
        for (int i = 0; i < nums.length-1; i++) { //i :0-(n-2)
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<nums[i]){
                    l=Math.min(l,i);
                    r=Math.max(r,j);
                }
            }
        }
        /*
        * r-1=-1 r=0时意味着整个数组是有序的
        * */
        return r-1<0?0:r-l+1;
    }
    /*
    * 解法二： 复制一个nums为temp_nums，temp_nums排序
    *          一一对应的比较，找出不对应的min，max（左侧右侧）
    * */
}
