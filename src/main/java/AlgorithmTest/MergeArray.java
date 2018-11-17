package AlgorithmTest;
/*
* 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
* 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
* 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
*
* */
public class MergeArray {
    public static void main(String[] args) {
        int nums1[]={
                1
        };
        int nums2[]={
           2
        };
        merge(nums1,1,nums2,1);

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        String result="";
        int i=0;
        int j=0;
        for(;i<m;){

            for(;j<n;){
                if(nums1[i]<=nums2[j])
                {
                    result+=nums1[i];
                    i++;
                    break;
                }else{
                    result+=nums2[j];
                    j++;

                }
            }
        }
        if(i<m){
            for(int p=j;p<n;p++){
                result+=nums1[p];
            }
        }
        if(j<n){
            for(int q=j;q<n;q++){
                result+=nums2[q];
            }

        }
        char [] charArray=result.toCharArray();
        String resultT="";
        for (int w = 0; w < charArray.length; w++) {
            resultT+=charArray[w]+",";
        }
        System.out.println("["+resultT.substring(0,resultT.length()-1)+"]");

    }
}
