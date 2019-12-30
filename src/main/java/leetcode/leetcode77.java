package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
   1...n 中的k个数的全排列
* */
public class leetcode77 {
    private List<List<Integer>> res = new ArrayList<>();
    /*
    pre 用来记录寻找中的组合,长度从1到k
    * */
    private void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
        if (pre.size()==k){
            res.add(new ArrayList<>(pre));
        }
        for (int i = begin; i <=n; i++) {
            pre.add(i);
            findCombinations(n,k,i+1,pre); //向下递归 begin 为i+1
            pre.pop(); //回溯
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        findCombinations(n,k,1,new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new leetcode77().combine(4,2));
    }
}
