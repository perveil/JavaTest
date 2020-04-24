package leetcode.sort.quicksort;

/*
* 寻找第k大 等价于寻找第n-k小
* */
public class leetcode215_数组中第K大个元素 {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        return quickSearch(nums,0,size-1,size-k);
    }
    private int quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return nums[k];
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v); //找到大于v的值
            while (--j >= lo && nums[j] > v); //找到小于v的值
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v; // j/i 为最终位置
        return j;
    }

    public static void main(String[] args) {
        new leetcode215_数组中第K大个元素().partition(new int[]{
                3,2,3,1,2,4,5,5,6
        },0,8);
    }
}
