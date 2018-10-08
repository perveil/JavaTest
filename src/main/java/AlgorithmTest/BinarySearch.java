package AlgorithmTest;
/*
* 题目一：在一个排序数组找到一个数出现的数组
* 例如：输入：{1，2，3，3，3，4，5} 3
* 输出 3
* 思路如下：
* 思路一： 遍历整个数组，index从0遍历到 最后一个目标数后边的第一个数 时间复杂度等于小于O(n)
* 思路二：既然是有序数组，那么通过二分查找找到目标数，然后从目标数向左向右遍历，统计个数
* 思路三(具体实现): 找到第一个和最后一个目标数出现的索引，然后相减加一
* 问题转移到如何找到第一个和最后一个目标数的索引：
*  根据二分查找：中间数如果小于目标数，那么目标数只能出现在后半部分，如果大于目标数，目标数只能出现在前半部分
*  如果等于，继续就向左/右遍历，如果向左/右的第一个数不是目标数，则要寻找就是第一个/最后一个数
* */
public class BinarySearch {
    public static void main(String[] args) {
        int [] array={1,2,3,3,3,4,5};
        int first=FindfirstKey(array,array.length,3,0,array.length-1);
        int end=FindendKey(array,array.length,3,0,array.length-1);
        System.out.println(end-first+1);  //输出结果
    }


    public  static  int  FindfirstKey(int [] array,int length,int k,int start,int end){
        if (start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if (array[mid]==k&&mid>0){ //如果找到关键字k
             if ((mid>0&&array[mid-1]!=k)||((mid-1)<0)){
                 return mid;
             }else{
                 end=mid-1;
             }
        }else if (array[mid]>k){ //如果大于
             end=mid-1;
        }else {    //如果小于
           start=mid+1;
        }
        return FindfirstKey(array,array.length,k,start,end);

    }
    public  static  int  FindendKey(int [] array,int length,int k,int start,int end){
        if (start>end){
            return -1;
        }
        int mid=(start+end)/2;
        if (array[mid]==k){ //如果找到关键字k
            if ((mid<array.length-1&&array[mid+1]!=k)||(mid==array.length-1)){
                return mid;
            }else{
                start=mid+1;
            }
        }else if (array[mid]>k){ //如果大于
            end=mid-1;
        }else {    //如果小于
            start=mid+1;
        }
        return FindendKey(array,array.length,k,start,end);
    }

}
