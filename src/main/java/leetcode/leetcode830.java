package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode830 {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> largeGroupPositions(String S) {
        char [] chars=S.toCharArray();
        char cur=chars[0];
        int start=0;
        int end=0;
        int num=1;
        for (int i = 1; i <chars.length ; i++) {
            if (chars[i]==cur){
                end++;
                num++;
            }else {
                if (num>=3){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(start);
                    temp.add(end);
                    list.add(temp);
                }
                cur=chars[i]; //改变此时的字符值
                end++;
                start=end;
                num=1;
            }

        }
        if (num>=3){
            List<Integer> temp=new ArrayList<>();
            temp.add(start);
            temp.add(end);
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        new leetcode830().largeGroupPositions("aaa");
    }
}
