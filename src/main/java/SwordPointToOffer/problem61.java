package SwordPointToOffer;

import java.util.Arrays;

public class problem61 {
    public boolean isStraight(int[] nums) {
        int []arr=new int[14]; //1-13
        int num=0;
        Arrays.fill(arr,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                num++;
            else
                if (arr[nums[i]]==1) return false; //有多个同样元素时，一定不连续
                arr[nums[i]]=1;
        }
        int left=-1;
        int right=-1;
        int gapnum=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=-1 && left!=-1){
                right=i;
                gapnum+=(right-left-1);
                left=right;
            }else if(arr[i]!=-1 &&left==-1 ){
                left=i;
            }
        }
        return gapnum==num;
    }

    public static void main(String[] args) {
        new problem61().isStraight(new int[]{
                0,0,2,2,5
        });
    }
}
