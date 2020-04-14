package leetcode.traceBack;
import java.util.*;

public class leetcode140_单词拆分 {
    /*
    * 暴力回溯超时,则采用记忆化回溯
    * */
    Map<Integer,List<String>> map=new HashMap<>(); //使用HashMap（key:value）: key:起始位置，value：从起始位置开始到字符串的末尾，所有可能的字符串
    Set<Integer> wordlenList=new HashSet<>(); //获得各个word的长度
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String s1:
             wordDict) {
            wordlenList.add(s1.length());
        }
        List<String> res=helper(0,s,wordDict);
        return res;
    }
    private List<String>  helper(int start,String s,List<String> wordDict){
        if (map.containsKey(start)) { //如果此时包含从start开始到 s.length的String list 则直接返回
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>(); //中间状态，记录从从start开始到 s.length的String list
        if (start==s.length()){
            res.add("");
        }
        for (Integer i: wordlenList) {
            if (start+i>s.length()) continue;
            String subs=s.substring(start,start+i);
            if (wordDict.contains(subs)){
                List<String> list=helper(start+i,s,wordDict); //得到从start+i到 s.length的String list
                for (String l : list) {
                    res.add(subs + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start,res);
        return res;
    }

    public static void main(String[] args) {
    }
}
