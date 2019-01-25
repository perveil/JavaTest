package sort;

import java.util.Arrays;
import java.util.Random;
/*
*  三路随机基准快速排序
*
* */
public class ThreeQuickSort {
    public static void main(String[] args) {
        int a[]={1,0,0,0,2,2};
        new ThreeQuickSort().swapNums(a,0,5);
        System.out.println(Arrays.toString(a));
    }
    //返回基数排序交换后的索引
    public void swapNums(int [] a,int left,int right){
        if (right<left) return;
        int randomIndex=new Random().nextInt(right-left+1)+left;
        swap(a,left,randomIndex);  //交换基准元素
        int temp=a[left];
        int lt=left;     // <基准的序列的末尾元素，初始化left
        int gt=right+1;  //>基准的序列的开头元素，初始为right+1
        int i = left + 1;
        while(i<gt)
        {
            if (a[i]<temp){
                swap(a,i,lt+1);
                lt++;  //<基准的索引++
                i++;   //此时是置换了一个==基准的到前面，所以不需要继续验证，直接++
            }else if (a[i]>temp){
                swap(a,i,gt-1);
                gt--;  //此时是从将大于基准的数置换到后边gt-1的位置，置换到i的数字仍然需要验证，所以i不动
            }else{
                i++;
            }
        }
        swap(a,left,lt);
        swapNums(a,left,lt-1);
        swapNums(a,gt,right);

    }
    public void swap(int a[],int p,int q){
        int temp=a[q];
        a[q]=a[p];
        a[p]=temp;
    }
}
