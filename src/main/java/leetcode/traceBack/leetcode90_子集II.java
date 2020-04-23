package leetcode.traceBack;/*
  @Date:2020/4/22 18:32
  @Author:Administrator
*/

import java.util.*;

public class leetcode90_子集II {
    List<List<Integer>> result =new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        helper(nums,0,track);
        return result;
    }
    public void helper(int[] candidates,int start,LinkedList<Integer> temp_list){
        result.add(new LinkedList<>(temp_list)); //添加结果
        for(int i=start;i<candidates.length;i++){ //思考为什么从start开始
            if(start<i&&candidates[i]==candidates[i-1]){ //剪枝
                //start<i，也就是说 start处的元素必须可以选
                continue;
            }
            temp_list.add(candidates[i]);
            helper(candidates,i+1,temp_list);
            temp_list.removeLast(); //回溯
        }
    }

    public static void main(String[] args) {
        new leetcode90_子集II().subsetsWithDup(new int[]{
                1,2,2
        });
    }
}
