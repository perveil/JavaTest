package leetcode.traceBack;

import java.util.ArrayList;
import java.util.List;

/*
* 回溯 超时
* */
public class leetcode552 {
    char [] d=new char[]{
      'A','L','P'
    };
    List<String> list=new ArrayList<>(); //组合数组
    public int checkRecord(int n) {
        int result=0;
        helper("",n);
        for (String s:
             list) {
            if(checkRecord(s)){
                result++;
            }
        }
        return result %( (int)Math.pow(10,9) + 7);
    }
    public void helper(String cur,int len){
        if (cur.length()==len){
            if (cur.indexOf("LLL")!=-1){
                return;
            }
            if (count(cur)>=2){
                return;
            }
            list.add(cur);
            return;
        }
        for (int i=0;i<3;i++){
            helper(cur+""+d[i],len);
        }
    }
    public int count(String s){
        char [] chars=s.toCharArray();
        int count=0;
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]=='A'){
                count++;
            }
        }
        return count;
    }
    public boolean checkRecord(String s) {
        char []chas=s.toCharArray();
        int numOfA=0;
        for(int i=0;i<chas.length;i++){
            if(chas[i]=='A'){
                numOfA++;
                if(numOfA>=2){
                    return false;
                }
            }else if(chas[i]=='L'){
                if(i+1<chas.length &&chas[i+1]=='L'
                        &&i+2<chas.length&&chas[i+2]=='L'){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode552().checkRecord(10);
    }

}
