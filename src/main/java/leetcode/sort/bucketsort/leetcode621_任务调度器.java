package leetcode.sort.bucketsort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
* 题解：https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/
* 关键：列优先分配
* */
public class leetcode621_任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        /*
        *  max_val 为字符出现最多次数-1 （分配n-1个桶）
        *  idle_slots  max_val*n 为空闲时间
        * */
        int max_val=map[25]-1,idle_slots=max_val*n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots-=Math.min(map[i], max_val);
            /*
            * Math.min(map[i], max_val) 为 map[i] 所对应字符运行所占的空闲时间
            * */
        }
        return idle_slots>0?idle_slots+tasks.length:tasks.length;
    }
}
