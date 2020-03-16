package leetcode;

public class leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        new leetcode88().merge(new int[]{
                1,2,3,0,0,0
        },3,new int[]{
                2,5,6
        },3);
    }
}
