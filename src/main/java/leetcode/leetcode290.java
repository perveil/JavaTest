package leetcode;

import java.util.HashMap;

public class leetcode290 {
    /*
    * leetcode 205 同解法
    * */
    public boolean wordPattern(String pattern, String str) {
        String patternToNum=StringTonums(pattern,"");
        String strTonum=StringTonums(str," ");
        return strTonum.equals(patternToNum);
    }
    public String StringTonums(String str,String re) {
        String [] strings=str.split(re);
        StringBuilder res=new StringBuilder();
        int num=1;
        HashMap<String,Integer> map=new HashMap<>();
        for (String s:
             strings) {
            if (!map.containsKey(s)){
                map.put(s,num);
                num++;
            }
        }
        for (String s:strings){
            res.append(map.get(s));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new leetcode290().wordPattern("abba","dog cat cat dog");
    }
}
