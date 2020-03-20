package leetcode.heap;

import java.util.PriorityQueue;

/*
* 求解数组中的前k个最小数
* */
public class interview40 {
    /*
    * 堆排序
    * */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k>arr.length) return null;
        int[] res=new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <arr.length ; i++) {
            queue.offer(arr[i]);
        }
        int k1=k;
        while(k-->0){
            res[k]=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        new interview40().getLeastNumbers(new int[]{
                3,2,1
        },2);
    }
}
