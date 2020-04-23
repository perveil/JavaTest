package leetcode;
/*
  @Date:2020/4/23 9:40
  @Author:Administrator
*/

import java.util.*;

public class interview61_扑克牌的顺子 {
    public boolean isStraight(int[] nums) {
        int []arr=new int[14]; //1-13
        int num=0; //大小王的数目
        Arrays.fill(arr,-1); //初始化数组
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)  //统计大小王的个数
                num++;
            else
            if (arr[nums[i]]==nums[i]) return false; //多出来一个则直接返回
            arr[nums[i]]=nums[i];
        }
        //统计gap数，间隔数
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
        return gapnum<=num;

    }
}
