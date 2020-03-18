package leetcode.heap;

import java.util.PriorityQueue;
/*
* PriorityQueue 的队头指向最小的元素，队尾指向最大元素，使用堆排序
* */
public class leetcode451 {
    public String frequencySort(String s) {
        //初始化字母数组
        int[] latters = new int[256];
        //填充数组
        for(char c:s.toCharArray()){
            latters[c]++;
        }
        PriorityQueue<Latter> queue = new PriorityQueue<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()){
            Latter latter = queue.poll();
            for (int i =0;i<latter.count;i++)
                stringBuilder.append(latter.latter);
        }
        return stringBuilder.toString();
    }


    public class Latter implements Comparable<Latter>{
        public char latter = '0';
        public int count = 0;

        public Latter(char latter, int count) {
            this.latter = latter;
            this.count = count;
        }

        @Override
        public int compareTo(Latter o) {
            return o.count - this.count;
        }
    }

}
