package leetcode;

import java.util.HashMap;

public class leetcode3 {
    //暴力法
    public int lengthOfLongestSubstring1(String s) {
        if(s.length()==0)  return 0;
        int [] nums=new int[26];
        char[] chars=s.toCharArray();
        int length=1;
        int maxlength=0;
        for(int i=0;i<chars.length;i++){
            for (int j = i; j <chars.length ; j++) {
                if (nums[(chars[j]-' ')%26]==0){
                    maxlength++;
                    nums[(chars[j]-' ')%26]=1;
                }else{
                    if (maxlength>length) length=maxlength;
                    maxlength=0;
                    for (int k = 0; k <nums.length ; k++) {
                        nums[k]=0;
                    }
                    break;
                }
            }
        }

        return length;
    }
    /*
    * 滑动窗口法：
    *   abcabcbb/bbbb
    * 应用HashMap Key-Value属性记录每一个字符出现的索引位置
    * left记录不含重复字符的子字符串的左边界
    * 如果出现了相同的字符,此时的i>left
    * left 变为之前出现的重复字符的位置
    * */
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)  return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        int left=0;
        for (int i = 0; i <s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1); //左边界变化
            }
            map.put(s.charAt(i),i); //覆盖重复字符的新位置
            max=Math.max(max,i-left+1);
        }
        return max;

    }

    public static void main(String[] args) {
       (new leetcode3()).lengthOfLongestSubstring1("abcabcbb");
        //System.out.println(('a'-' ')%26);
    }
}
