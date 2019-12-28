package leetcode;

import java.util.*;

/*
*    先排序，然后循环筛选
* */
public class leetcode954 {
    public static void main(String[] args) {
        System.out.println(
                new leetcode954().canReorderDoubled(
                        new int[]{
                                -1,-2
                        }
                )
        );
    }
    public boolean canReorderDoubled(int[] A) {
        if (A.length==0) return true;
        Map<Integer, Integer> counts = new TreeMap<>();
        for(int a : A) {
            counts.put(a, counts.getOrDefault(a, 0) + 1);
        }
        for(int a : counts.keySet()) {
            if(counts.get(a) == 0) {
                              continue;
            }
            if(a < 0) {
                 if(counts.get(a) > counts.getOrDefault(a / 2, 0)) {
                     return false;
                 }
                  counts.put(a / 2, counts.get(a / 2) - counts.get(a));
            } else {
                if(counts.get(a) > counts.getOrDefault(a * 2, 0)) {
                    return false;
                }
                counts.put(a * 2, counts.get(a * 2) - counts.get(a));
            }

        }

        return true;
    }
}
