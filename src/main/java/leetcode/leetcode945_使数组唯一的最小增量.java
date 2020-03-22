package leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class leetcode945_使数组唯一的最小增量 {
    /*
    * 暴力超时 时间复杂度约等于O(n^2)
    * */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <A.length ; i++) {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        for (int i=0;i<A.length;i++) {
            int k_temp=A[i];
            if (map.get(k_temp)>1){
                while(map.containsKey(++k_temp)); //找到当前所不存在的大值
                res+=k_temp-A[i];
                // A[i]=k_temp; //自增之后修改值
                map.put(k_temp,1);                              //添加新增的值
                map.put(A[i],map.getOrDefault(A[i],0)-1); //重复个数-1
            }
        }
        return res;
    }
    /*
    * 贪心法 ：
    * 1 1 2 2 3 7
    * 1 2 3 4 5 7
    *   1 1 2 2   =6
    * 只前前一个数有关的局部最优
    * */
    public int minIncrementForUnique2(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(A);
        int preNum = A[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            // preNum + 1 表示当前数「最好」是这个值
            if (A[i] == preNum + 1) {
                preNum = A[i];
            } else if (A[i] > preNum + 1) {
                // 当前这个数已经足够大，这种情况可以合并到上一个分支
                preNum = A[i];
            } else {
                // A[i] < preNum + 1
                res += (preNum + 1 - A[i]); // A[i] 直接变到 preNum+1
                preNum++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode945_使数组唯一的最小增量().minIncrementForUnique(new int[]{
                3,2,1,2,1,7
        });
    }
}
