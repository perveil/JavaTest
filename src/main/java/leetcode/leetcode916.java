package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
* 最简单的是想法是针对B数组，把B数组中的元素合并成一个B中所有出现的相同的最长连续字符串的字符数组
*
*
* */
public class leetcode916 {
    public static void main(String[] args) {
        new leetcode916().wordSubsets(
                new String[]{
                        "amazon","apple","facebook","google","leetcode215"
                },new String[]{
                        "e","oo"
                }
        );
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        ArrayList<String> results=new ArrayList<>();
        int []com=aimStr(B[0]);
        for (int i = 1; i <B.length ; i++) {
            combine(com,aimStr(B[i]));
        }  //获得B数组的所有最长的单词
        for (String s:
             A) {
            if (find(aimStr(s),com)) results.add(s);
            
        }
        return results;
    }
    private void combine(int[] a, int[] b) {
        for (int i=0;i<26;i++) {
            a[i] = Math.max(a[i],b[i]);
        }
    }
    public boolean find(int [] charSet2,int[] charSet){
        boolean is=true;
        for (int j = 0; j <charSet.length; j++) {
            if (charSet[j]!=0&&charSet2[j]<charSet[j]){
                is=false;
                break;
            }
        }
        return is;
    }
    public int [] aimStr(String B){
        int [] charSet=new int[26];
        char []array= B.toCharArray();
        for (int j = 0; j <array.length ; j++) {
                charSet[array[j]-'a']++;
        }
        return charSet;
    }
}
