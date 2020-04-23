package leetcode;
/*
  @Date:2020/4/23 9:49
  @Author:Administrator
*/

import java.util.*;

public class leetcode414_第三大的数 {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new RuntimeException("error");
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) set.remove(set.first()); //只找后三个元素

        }
        return set.size() < 3 ? set.last() : set.first();
    }
}
