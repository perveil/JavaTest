package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode1160 {
    public int countCharacters(String[] words, String chars) {
        int res=0;
        Map<Character,Integer> own=new HashMap<>();
        for (Character c:
             chars.toCharArray()) {
            own.put(c,own.getOrDefault(c,0)+1);
        }
        for (int i = 0; i <words.length ; i++) {
            char [] temp=words[i].toCharArray();
            Map<Character,Integer> tempmap=new HashMap<>();
            boolean ismatch=true;
            for (char c:
                 temp) {
                tempmap.put(c,tempmap.getOrDefault(c,0)+1);
                if (own.getOrDefault(c,0)==0||tempmap.get(c)>own.get(c)){ //字符表么没有或者少于
                    ismatch=false;
                }
            }
            if (ismatch){
                res+=words[i].length();
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        new leetcode1160().countCharacters(new String[]{
                "hello","world","leetcode"
        },"welldonehoneyr");
    }
}
