package leetcode;


import java.util.HashMap;
import java.util.Stack;

public class leetcode496 {
      class Solution {
          //贪心法
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int [] result=new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                for(int j=0;j<nums2.length;j++){
                    if(nums2[j]==nums1[i]){
                        for(int p=j+1;p<nums2.length;p++) {
                            if (nums2[p] > nums1[i]) {
                                result[i] = nums2[p];
                                break;
                            }
                        }
                    }

                }
            }
            for(int i=0;i<nums1.length;i++){
                if(result[i]==0) result[i]=-1;
            }
            return result;
        }
        //单调栈
        public int[] SnextGreaterElement(int[] nums1, int[] nums2) {
              Stack<Integer> s = null;
              int[] res = new int[nums1.length];
              for(int i=0;i<nums1.length;i++){
                  res[i] = -1;
                  s = new Stack<Integer>();
                  for(int m:nums2){
                      s.push(m);
                  }
                  while(!s.empty()&&s.peek()!=nums1[i]){
                      if(s.peek()>nums1[i]){
                          res[i] = s.pop();
                      }else{
                          s.pop();
                      }
                  }

              }
              return res;
          }

          //只用栈
          public int[] S2nextGreaterElement(int[] nums1, int[] nums2) {
              Stack<Integer> stack = new Stack<>();

              HashMap<Integer,Integer> maps = new HashMap<Integer,Integer>();

              for(int i = 0;i<nums2.length;i++){
                  while(!stack.isEmpty() && stack.peek()<nums2[i]){
                      maps.put(stack.pop(),nums2[i]);
                  }
                  stack.push(nums2[i]);
              }

              int[] result = new int[nums1.length];
              for(int i = 0;i<nums1.length;i++){
                  result[i] = maps.getOrDefault(nums1[i],-1);
              }

              return result;
          }
    }

    public static void main(String[] args) {
        new leetcode496().new Solution().S2nextGreaterElement(
                new int[]{
                        4,1,2
                },
                new int[]{
                        1,3,4,2,6,8
                }
        );
    }
}
/*
*
* [3,1,5,7,9,2,6]
[1,2,3,5,6,7,9,11]
* */