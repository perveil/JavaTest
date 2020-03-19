package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder res=new StringBuilder();
        res.append(S.substring(0,indexes[0])); //把头接上来
        List<Integer> curindexes=new ArrayList<>();
        for (int i = 0; i < indexes.length-1; i++) {
            if (S.substring(indexes[i],indexes[i]+sources[i].length())==sources[i]){
                curindexes.add(indexes[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        new leetcode833().findReplaceString( "abcd",new int[]{
                0,2
        },new String[]{
                "ab","ec"
        },new String[]{
                "eee","ffff"
        });
    }
}
