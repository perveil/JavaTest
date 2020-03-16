package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
* @author laiso
* */
public class leetcode46 {
    public static void main(String[] args) {
        System.out.println(
            new leetcode46().permute(new int[]{
                    1,1,3
            })
        );

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        perm(result,nums,0,nums.length-1);
        return result;
    }
    public void perm(List<List<Integer>> result,int[] aim,int k,int m) {
        if (k==m){
            List<Integer> list=new ArrayList<>();
            for (int i=0;i<=m;i++){
                list.add(aim[i]);
            }
            System.out.println();
            result.add(list);
        }else{
            // 交换子序列的第一个字母 所有可能出现的可能性
            for (int i=k;i<=m;i++){
                if (isSwap(aim,k,i)){
                    swap(aim,k,i);
                    perm(result,aim, k+1, m);
                    swap(aim,k,i); //回溯，专注于交换子列表的第一个数字(与后边所有可以出现的可能交换)
                }
            }
        }
    }
    public  void swap(int [] aim,int k,int m){
        int temp=aim[m];
        aim[m]=aim[k];
        aim[k]=temp;
    }
    /*
    * 1,2,2
    *  1，我们依照思路交换第一个2和第一个1 的位置-》2，1，2  向下递归 2，2，1
    *  2，第一个1和第二个2交换 2，1，2 向下递归 2，2，1 全部与第一步的结果重复
    *  3，发现规律，我们只和相同数字的第一个数字交换，而不和已经出现过的数字交换
    * */
    public  boolean isSwap(int [] aim,int k,int m){
        for(int index = k;index<m;index++)
        {
            if(aim[index]==aim[m])
                return false;
        }
        return true;
    }
}
