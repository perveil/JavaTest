package leetcode.traceBack;

import java.util.ArrayList;
import java.util.List;

public class leetcode60_第k个排列 {
    List<String> result=new ArrayList<>();
    public String getPermutation(int n, int k) {
        String s="";
        for (int i=1;i<=n;i++){
            s+=i;
        }
        return helper("",n,s,k);
    }
    String  helper(String cur,int size,String remain,int aim){
        if (cur.length()==size){
            result.add(cur);
            if (result.size()==aim) return result.get(aim-1);
        }
        for (int i=0;i<size-cur.length();i++){
            if (
            helper(cur+""+remain.charAt(i),
                    size,
                    remain.substring(0,i)+remain.substring(i+1),
                    aim)!=null){
                return result.get(aim-1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new leetcode60_第k个排列().getPermutation(4,9);
    }
}
