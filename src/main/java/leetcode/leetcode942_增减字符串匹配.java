package leetcode;

public class leetcode942_增减字符串匹配 {
    public int[] diStringMatch(String S) {
        int max=S.length();
        int min=0;
        int res[]=new int[S.length()+1];
        for (int i = 0; i <S.length() ; i++) {
            if (S.charAt(i)=='I'){
                res[i]=min;
                min++;
            }else {
                res[i]=max;
                max--;
            }
        }
        res[S.length()]=max;

        return res;
    }
}
