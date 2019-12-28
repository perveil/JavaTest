package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key : map.keySet()) {
            int frequency = map.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        for(int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
            if(bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }
        return ret;


    }
}
