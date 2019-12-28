package leetcode;

import java.util.*;
/*
*  1.贪心法简单粗暴
*  2.二分法 ： 其实还是离不开贪心法
*   1.先对word 去重
*   2.记录S 中么一个元素出现的位置，维护一个map<String,List<Integer>> List<Integer>是相对有序的
*    遍历每一个word 然后遍历word 中的每一个字符在map中的是不是满足位置上的约束，都满足就加一
*  3. 字典树  https://blog.csdn.net/jiutianhe/article/details/8076835
*
*
* */
public class leetcode792 {
    public static void main(String[] args) {

        System.out.println(
            new Solution().numMatchingSubseq(
                    "abcde",new String[]{
                            "a", "bb", "acd", "ace"
                    }
            )
        );
    }

}
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        int result=0;
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else{
                map.put(words[i],1);
            }
        }
        List<String> set= new LinkedList<>(map.keySet());
        for(Iterator iterator = set.iterator(); iterator.hasNext();){
            String key=(String) iterator.next();
            if(leetcode392.isSubsequence(key,S)){
                result+=map.get(key);
            }
        }
        return result;
    }
}
