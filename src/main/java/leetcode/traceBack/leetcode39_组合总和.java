package leetcode.traceBack;
/*
  @Date:2020/4/15 16:13
  @Author:Administrator
*/

import java.util.*;

public class leetcode39_组合总和 {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); //排序，从小到大的排序数组是种优化手段
        LinkedList<Integer> track = new LinkedList<>();
        helper(candidates,target,0,track);
        return result;

    }
    //递归
    public void helper(int[] candidates,int target,int start,LinkedList<Integer> temp_list){
        if(target==0){ //结束条件
            result.add(new LinkedList<>(temp_list)); //添加结果
            return;
        }
        if(target<0){ //直接结束
            return;
        }
        for(int i=start;i<candidates.length;i++){ //思考为什么从start开始
            if(candidates[i] > target) //数组为有序数组
                break;
            temp_list.add(candidates[i]);
            helper(candidates,target-candidates[i],i,temp_list);//思考为什么从i开始？
            temp_list.removeLast(); //回溯
        }
    }
}
