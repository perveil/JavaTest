package leetcode;/*
  @Date:2020/4/26 9:57
  @Author:Administrator
*/

import leetcode.LinkedList.ListNode;

import java.util.*;
/*
* 大根堆
*
* */
public class leetcode692_前K个高频单词 {
    //数据结构写法
    static class Node implements Comparable<Node>{
        public String str;
        public int freq;
        Node(String str){
            this.str=str;
            freq=0;
        }

        @Override
        public int compareTo(Node o) {
            if (this.freq==o.freq){
                return this.str.compareTo(o.str);
            }else {
                return  this.freq-o.freq;
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap=new PriorityQueue<String>(
                (w1,w2)->count.get(w1).intValue()==count.get(w2).intValue()?
                        w2.compareTo(w1):count.get(w1).intValue()-count.get(w2).intValue()
        );
        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll(); //溢出来就扔掉
        }
        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }

}
