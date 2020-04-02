package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode139_单词拼接_记忆化递归 {
     /*
     * 若干个wordDict 中所有的单词 是否可以拼接成s
     * */
     HashMap<Integer,Boolean> map = new HashMap<>(); //Integer i,boolean true 指的是从i开始之后的字符串是否可以由wordDict 组成
     List<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict=wordDict;
        int max=Integer.MIN_VALUE;
        for (String w: wordDict) {
            max=Math.max(w.length(),max);
        }
        return getResult(s,0,max);

    }
    private boolean getResult(String s, int start,int max) {
        if (start==s.length()){
            return true;
        }
        if (map.containsKey(start)){
            return map.get(start);
        }
        /*
        * 每个可能的单词都不能超过max代表的长度
        * */
        for (int i = start; i <start+max&&i<s.length() ; i++) {
            if (dict.contains(s.substring(start,i+1))){
                if (getResult(s,i+1,max)){
                    map.put(start,true);
                    return true;
                }
            }
        }
        map.put(start,false);
        return false;
    }


}
