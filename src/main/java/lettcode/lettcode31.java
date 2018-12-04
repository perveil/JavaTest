package lettcode;

import java.util.Arrays;

/*
* 出错
* */

public class lettcode31 {

    public static void main(String[] args) {
        new lettcode31().nextPermutation(new int[]{
            4,3,2,7,5,4
        });
    }
    public void nextPermutation(int[] nums) {
        if (nums.length<=1){
            System.out.println(nums[0]);
        }
        boolean flag=true;
        for(int i=nums.length-1;i>-1;i--){
            if(i-1>-1&&nums[i]>nums[i-1]){
                int temp=nums[i-1];
                for(int j=i+1;j<nums.length;j++){
                    if (j+1<nums.length&&nums[j]<nums[j+1]){
                        nums[i-1]=nums[j];
                        nums[j]=temp;
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    nums[i-1]=nums[i];
                    nums[i]=temp;
                    flag=false;
                    break;
                }
            }
        }
        if(flag){
            Arrays.sort(nums);
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }
}
