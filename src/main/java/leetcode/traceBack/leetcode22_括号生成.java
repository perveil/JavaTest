package leetcode.traceBack;

import java.util.ArrayList;
import java.util.List;

public class leetcode22_括号生成 {

    List<String> res=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return res;
        helper("",0,0,n);
        return res;
    }
    public void helper(String cur,int open,int close,int max){
        if(cur.length()==2*max){
            res.add(cur);
            return;
        }
        if(open<max){
            helper(cur+"(",open+1,close,max);
        }
        if(open>close){ //当左括号数大于右括号数是才可以加右括号
            helper(cur+")",open,close+1,max);
        }
    }

    public static void main(String[] args) {
        new leetcode22_括号生成().generateParenthesis(3);
    }
}
