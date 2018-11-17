package AlgorithmTest;
/*
* 题目一：java实现并归排序：
* 使用分治法来实现程序，具体看博客：https://www.cnblogs.com/chengxiao/p/6194356.html
*
*
* 题目二：在数组里边的两个数字，如果前面的数字大于后面的数字时，则是一个逆序对，输入一个数组，输出逆数对的个数
*
* */
public class NumberSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort1(arr);
    }
    public static void  sort1(int [] arr){
        int []temp = new int[arr.length];
        int result=0;
        System.out.println(sort(arr,0,arr.length-1,temp,result));

    }
    private static int sort(int[] arr,int left,int right,int []temp,int result){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp,result);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp,result);//右边归并排序，使得右子序列有序
            return result+merge(arr,left,mid,right,temp);
        }
       return 0;
    }
    private static int merge(int[] arr,int left,int mid,int right,int[] temp){
        //题目2：
        int result=0;
        int left_last=mid-1;
        int right_last=right;
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        /*
        * 寻找逆序对
        * */
        while(left_last>=left &&right_last>=mid+1){
            if (arr[left_last]>arr[right_last]){
                result+=right_last-mid;
                left_last--;
            }else{
                right_last--;
            }
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
        return  result;
    }

}
