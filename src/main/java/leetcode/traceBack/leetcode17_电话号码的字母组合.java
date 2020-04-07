package leetcode.traceBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode17_电话号码的字母组合 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            helper(new StringBuilder(), digits);
        return output;
    }
    private  void helper(StringBuilder cur,String digits){
        if (digits.equals("")){
            output.add(cur.toString());
            return;
        }
        String aim=digits.charAt(0)+"";
        char [] chars=phone.get(aim).toCharArray();
        for (char c:chars){
            helper(cur.append(c),digits.substring(1)); //递归
        }

    }

    public static void main(String[] args) {
        new leetcode17_电话号码的字母组合().letterCombinations("23");
    }

}
