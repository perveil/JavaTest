package leetcode.sildeWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode30_串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>(); //目标wordmap
        int one_word = words[0].length();
        for (String word:
             words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //i<s.length() - one_word*words.length + 1 的意思是要最少满足one_word*words.length的长度
        //i<one_word 表示
        for (int i = 0; i <one_word; i++) {
            int left = i, right = i, count = 0; //滑动窗口
            HashMap<String, Integer> tmp_map = new HashMap<>(); //目前的wordmap
            while(right+one_word<=s.length()){
                String w=s.substring(right,right+one_word);
                right+=one_word;
                if (!map.containsKey(w)){ //断开
                    count=0;
                    left=right;
                    tmp_map.clear();
                }else {
                    tmp_map.put(w,tmp_map.getOrDefault(w,0)+1);
                    count++;
                    /*
                    * 当w的个数多出来时，left右移
                    * */
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {  //多出来的时候向左移
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count==words.length) res.add(left);  //多出来的都已经除去，除去之后依然合理则得出结果
                }
            }
        }
        return res;
    }
}
