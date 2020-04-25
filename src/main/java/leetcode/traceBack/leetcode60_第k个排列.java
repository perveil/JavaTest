package leetcode.traceBack;

import java.util.ArrayList;
import java.util.List;

public class leetcode60_第k个排列 {
    /*
    * 暴力回溯超时
    * */
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
    /*
    * 找规律,全排列的性质
    * https://bangbingsyb.blogspot.com/2014/11/leetcode-permutation-sequence.html
    * 例如 4，9
    *  固定一位，剩余位的组合个数是剩余位个数的阶乘，则可以求出固定位
    * */
    public String getPermutation2(int n, int k) {
        String res="";
        int[] fc=new int[n]; //fc[i]=(i-1)!
        List<Character> ch=new ArrayList<>();
        fc[0]=1;
        for (int i = 1; i <n ; i++) {
            fc[i]=fc[i-1]*i;
        }
        for (int i = 1; i <=n ; i++) {
            ch.add((i+"").charAt(0));
        }
        k--;
        for (int i = n; i >=1 ; i--) {
            int j=k/(fc[i-1]) +1; //求出此位的数字
            k%=(fc[i-1]);
            res+=ch.get(j-1);
            ch.remove(j-1);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode60_第k个排列().getPermutation2(4,9);
    }
}
