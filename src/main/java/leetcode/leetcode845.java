package leetcode;

public class leetcode845 {
    public static void main(String[] args) {
        new leetcode845().longestMountain(new int[]{
                2,1,4,7,3,2,5
        });
    }
    //最简单的贪心法
    public int longestMountain(int[] A) {
        int result=0;
        for(int i=1;i<A.length;i++){
            int rightIndex=i;
            int leftIndex=i;
            while(rightIndex+1<A.length&&A[rightIndex]>A[rightIndex+1]){rightIndex++;}
            while(leftIndex-1>-1&&A[leftIndex]>A[leftIndex-1]){leftIndex--;}
            int temp=rightIndex-leftIndex+1<3||rightIndex==i||leftIndex==i?0:rightIndex-leftIndex+1;
            if(result<temp) result=temp;
        }
        return result;
    }
}
