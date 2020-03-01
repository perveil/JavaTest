package leetcode.sildeWindow;

import java.util.HashMap;

public class Interview1718 {
    HashMap<Integer,Integer> need=new HashMap<>();
    HashMap<Integer,Integer> cur=new HashMap<>();
    int min_len=Integer.MAX_VALUE;
    public int[] shortestSeq(int[] big, int[] small) {
        if (small.length>big.length) return  null;
        int []res=new int[2];
        for (int i = 0; i <small.length ; i++) {
            int count=need.getOrDefault(small[i],0);
            need.put(small[i],count+1);
        }
        int required=need.size();//需匹配的数目
        int left=0;
        int right=0;
        int start=0; //记录最小子数组的起始位置
        int match=0;
        while(right<big.length){
            if (need.containsKey(big[right])){
                int count=cur.getOrDefault(big[right],0);
                cur.put(big[right],count+1);
                if (need.get(big[right]).intValue()==
                cur.get(big[right]).intValue()){
                    match++;
                }
            }
            right++; //右指针右移
            while(match==required){//开始验证左边界
                if (right-left<min_len){
                    start=left;
                    min_len=right-left;
                }
                if (need.containsKey(big[left])){
                    cur.put(big[left],cur.get(big[left])-1);
                    if (cur.get(big[left]).intValue()<need.get(big[left]).intValue()){
                        match--;
                    }
                }
                left++;
            }
        }
        res[0]=start;
        res[1]=start+min_len-1;
        return  res;
    }

    public static void main(String[] args) {
        new Interview1718().shortestSeq(new int[]{
                7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7
        },new int[]{
                1,5,9
        });
    }
}
