package sort;

import java.util.Arrays;
import java.util.Random;

/*
* 单路快速排序
* 由于 单路快速排序仰仗于目标的既定数组的初始排序情况（取基数是只取序列的第一个数），最好时Ω(nlogn)，最坏时Ω(n^2)
* 所以我们改变取基数的方法，使用随机数来取基数
* */
public class SimpleQuickSort {
    public static void main(String[] args) {
        int a[]={5,6,9,1,7,6,2,3,8};
        new SimpleQuickSort().quickSort(a,0,8);
        System.out.println(Arrays.toString(a));
    }
    public void quickSort(int [] nums,int start,int end){
        //选择基数 0
        if (start<end){
            int index=swapNums(nums,start,end);
            quickSort(nums,start,index-1);
            quickSort(nums,index+1,end);
        }
    }
    //返回基数排序交换后的索引
    public int swapNums(int [] a,int left,int right){
        int i=left;
        int j=right;
        //产生随机数之后，向头部或者尾部交换基数，因为目的是交换除了基数的某个特定区域的序列
        int temp=a[new Random().nextInt(right-left+1)+left];
        int leftNum=a[left];
        a[left]=temp;
        temp=leftNum;
        while(i<j)
        {
            while(i<j && a[j]>=temp)
                j--;
            if(i<j)
                a[i]=a[j];
            while(i<j && a[i]<=temp)
                i++;
            if(i<j)
                a[j]=a[i];
        }
        a[i]=temp;
        return i;
    }
}
