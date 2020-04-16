package leetcode.traceBack;/*
  @Date:2020/4/15 16:19
  @Author:Administrator
*/

import java.util.*;

public class leetcode40_组合总和II {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//排序
        LinkedList<Integer> track = new LinkedList<>(); //为什么使用LinkedList
        helper(candidates,target,0,track);
        return result;

    }
    //递归
    public void helper(int[] candidates,int target,int start,LinkedList<Integer> temp_list){
        if(target==0){
            result.add(new LinkedList<>(temp_list)); //添加结果
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i] > target) //数组为有序数组
                break;
            if(i>start&&candidates[i]==candidates[i-1])  // 去重 i>start==>以防数组溢出
            {
                continue;
            }
            temp_list.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,temp_list);//思考为什么从i+1开始？
            temp_list.removeLast(); //回溯
        }
    }
}
