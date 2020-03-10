package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
*  数组中存在的一些x的个数是整个数组的度，最短子数组是某一个x最左边到最右边的距离加一
* */
public class leetcode697 {
    int min;
    public int findShortestSubArray(int[] nums) {
        min=nums.length; //最大为nums.length
        Map<Integer,Integer> left=new HashMap<>(),
        right=new HashMap<>(),count=new HashMap<>();
        //count 记录每一个数字的个数
        //left、right 记录每一个数字开始出现的位置和结束的位置
        for (int i = 0; i <nums.length; i++) {
            int x=nums[i];
            if (!left.containsKey(x)) left.put(x,i);
            right.put(x,i);
            count.put(x,count.getOrDefault(x,0)+1);
        }
        int degree=0;
        for (Integer i:
             count.keySet()) {
            degree=Math.max(count.get(i),degree);
        }
        for (Integer i:
                count.keySet()) {
            if (count.get(i)==degree){
                min=Math.min(min,right.get(i)-left.get(i)+1);
            }

        }




        return min;
    }
}
