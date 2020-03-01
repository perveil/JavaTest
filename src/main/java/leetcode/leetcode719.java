package leetcode;


import java.util.*;

public class leetcode719 {
    /*
    * 超出空间限制
    * */
    ArrayList<Integer> list=new ArrayList<>();
    LinkedList<Integer> num=new LinkedList<>();
    public int smallestDistancePair(int[] nums, int k) {
        //if (nums.length==0||k<=0) return 0;
        helper(nums,0,nums.length-1,2);
        Collections.sort(list);
        return list.get(k-1).intValue();
    }
    public void helper(int [] nums,int start,int end,int n){
        if (n==0){
           list.add(Math.abs(num.get(0)-num.get(1)));
            return;
        }
        for (int i = start; i <=end; i++) {
            num.addLast(nums[i]);
            helper(nums,i+1,end,n-1);
            num.removeLast();
        }
    }

    public static void main(String[] args) {
        new leetcode719().smallestDistancePair(new int[]{
                1,3,1
        },1);
    }
}
