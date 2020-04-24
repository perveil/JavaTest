package leetcode.sort.quicksort;
/*
* 同类型题有 leetcode75
* */
public class leetcode912_排序算法 {
    public void quicksort(){
        int []nums=new int[]{
                5,2,3,1
        };
        quicksorthelper(nums,0,nums.length-1);
    }
    public void quicksorthelper(int [] nums,int start,int end){
        int privot=nums[start];
        int i=start;
        int j=end;
        if (i>=j||i>nums.length-1) return;
        while(i<j){ // 搜索区间 [i,j]
            while(i<j&&nums[j]>privot){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<=privot){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=privot;
        quicksorthelper(nums,start,i-1); //递归左半部分
        quicksorthelper(nums,i+1,end);   //递归右半部分
    }

    public static void main(String[] args) {
        new leetcode912_排序算法().quicksort();
    }
}
