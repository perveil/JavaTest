package leetcode.binarySearch;

public class leetcode4_两个有序数组的中位数 {
    /*
    * note:
    * 1. i 与j 的关系
    * j=(m+n+1)/2 -i
    * i 增大j减小   i减少 j增大
    * 0<=i<=m-1,为了保证0<=j<=n-1 必须保证m<=n
    * m≤n,i<m j=(m+n+1)/2−i≥(m+m+1)/2−i>(m+m+1)/2−m=0 (i取m)
    * m≤n,0<=i，j=(m+n+1)/2−i≤(n+n+1)/2−i<(n+n+1)/2=n （i取0）
    *
    * 2.
    * 0-（i-1） | i-m
    * 0-（j-1） | j-n
    * m+n为偶数时 j-1+i-1=m-i-1+n-j-1 =》(m+n)/2-i=j
    * m+n 为奇数时， j-1+i-1=m-i+n-j+1 ，假设左边比右边多一个 => (m+n+1)/2-i=j
    * 由于java的整数除法 默认向下取整
    * min(nums1[i],nums2[j])>max(nums1[i-1],nums2[j-1])
    *
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n)
            return findMedianSortedArrays(nums2,nums1); //保证m<=n
        int iMin = 0, iMax = m; //目标是对i进行操作
        while (iMin<=iMax){
            int i=(iMax+iMin)/2; //二分法
            int j=(m+n+1)/2 -i; // j与i负相关
            if (j!=0 && i!=m && nums2[j-1]>nums1[i]){ //iMin 变大 代表着 i变大
                iMin=i+1;
            }else if (i!=0 &&j!=n && nums1[i-1]>nums2[j]){ //iMax 变小，代表着 i变小
                iMax=i-1;
            }else{ //满足条件
                int maxLeft=0; //找到左半部分的最大值
                //考虑边界条件
                if (i==0){ //整个nums1 数组被划分在了右边
                    maxLeft=nums2[j-1]; }
                else if (j==0) maxLeft=nums1[i-1];
                else {maxLeft=Math.max(nums1[i-1],nums2[j-1]);}
                if ((m+n)%2==1) return maxLeft; // 奇数时，直接返回左边最大值

                int minright=0; //找到右半部分的最小值
                if (i==m){
                    minright=nums2[j];
                }
                else  if (j==n){
                    minright=nums1[i];
                }
                else {
                    minright=Math.min(nums1[i],nums2[j]);
                }
                return (minright+maxLeft)*1.0/2;
            }
        }
        return 0.0;
    }
}
