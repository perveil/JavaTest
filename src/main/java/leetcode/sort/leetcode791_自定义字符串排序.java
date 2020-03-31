package leetcode.sort;

import java.util.HashMap;

public class leetcode791_自定义字符串排序 {
    public String customSortString(String S, String T) {
        StringBuilder end=new StringBuilder();    //没有出现在S中的字符
        StringBuilder start=new StringBuilder();  //出现在了S中的字符
        HashMap<Character,Integer> sortMap=new HashMap<>();
        int[] chars=new int[26];
        int num=S.length();
        for (int i=0;i<S.length();i++) {
            sortMap.put(S.charAt(i),i);
        }
        for (int i = 0; i <T.length() ; i++) {
            if (!sortMap.containsKey(T.charAt(i))){ //sortedmap中没有的元素
                end.append(T.charAt(i));
            }
            chars[T.charAt(i)-'a']++;
        }
        /*
        * 排序，在对应sortedmap里边找到chars所对应的元素
        * */
        for (int i = 0; i <num ; i++) {
            for (int j = 0; j <26 ; j++) {
                if(chars[j]>0){
                    if (sortMap.containsKey((char)('a'+j))&&sortMap.get((char)('a'+j))==i){
                        for (int k = 0; k <chars[j]; k++) {
                            start.append((char)('a'+j));
                        }
                    }
                }
            }
        }

        return start.append(end.toString()).toString();
    }

    public static void main(String[] args) {
        new leetcode791_自定义字符串排序().customSortString("cba" ,
                "cbad");
    }
}
