package leetcode.traceBack;

import java.util.ArrayList;
import java.util.List;

/*
*   递归加回溯=>分治
* */
public class leetcode131_分割回文字符串 {
    List<List<String>> methods=new ArrayList<>();
    public List<List<String>> partition(String s) {
        int len=s.length();
        partitionHelper(s,0,len,new ArrayList<String>());
        return methods;
    }
    public void partitionHelper(String s,int start,int end,List<String> list) {
        if (start==end) {
            methods.add(new ArrayList<>(list));
        }
        for (int i=start+1;i<=end;i++){
            if (isPalindrome(s.substring(start,i))){ //i=start+1 是切割出一个字符
                list.add(s.substring(start,i));
                partitionHelper(s,i,end,list);
                list.remove(list.size() - 1); //回溯
            }
        }
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode131_分割回文字符串().partition("aab");
    }

}
