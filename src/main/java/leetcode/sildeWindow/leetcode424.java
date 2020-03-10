package leetcode.sildeWindow;

/*
* 同leetcode 1004
* */
public class leetcode424 {
    private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if(s==null) return 0;
        int left=0;
        int right=0;
        int curmax=0; //记录此时窗口内最多字符的个数
        for (; right < s.length(); right++) {
            int index=s.charAt(right)-'A';
            map[index]++; //向右扩张
            curmax=Math.max(curmax,map[index]);
            if (right-left+1>curmax+k){ //此时窗口的字符数量大于最多字符数量+可替换数量,缩减窗口
                map[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }
}
