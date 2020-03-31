package leetcode.sort.bucketsort;

public class BucketSort {
    public int[] sortArray(int[] nums) {
        int max = -50001, min = 50001;
        for (int num: nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }


        int[] counter = new int[max - min + 1];
        for (int num: nums) {
            counter[num - min]++;
        }

        int idx = 0;
        for (int num = min; num <= max; num++) {
            int cnt = counter[num - min];
            while (cnt-- > 0) {
                nums[idx++] = num;
            }
        }
        return nums;
    }
}
