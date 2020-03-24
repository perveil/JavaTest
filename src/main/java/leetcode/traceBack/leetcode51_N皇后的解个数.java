package leetcode.traceBack;

public class leetcode51_N皇后的解个数 {
    int res=0;
    public int totalNQueens(int n) {
        int[][]nums=new int[n][n];
        helper(n,0,nums);
        return res;
    }
    /*
    * cur 代指当前层数
    * n  代指总共层数
    * */
    public void helper(int n,int cur,int [][] nums) {
        if(cur>=n){
            res++; //终止条件
            return;
        }
        for(int i=0;i<n;i++){
            nums[cur][i]=1;//设置值
            if(is(cur,i,nums)){
                helper(n,cur+1,nums);
            }
            nums[cur][i]=0;//回溯
        }
    }
    public boolean is(int x,int y,int [][]nums) {  //在i，j位置上放置的合理性
        for(int i=0;i<x;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==1&&(j==y||Math.abs(x-i)==Math.abs(y-j))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode51_N皇后的解个数().totalNQueens(4);
    }
}
