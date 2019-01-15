package AlgorithmTest;
/*
*题目：从旋转数组里边找最小值--》查找
* {1，2，3，4，5}  =》本身就是一个旋转数组
* {3,4,5,1,2}  也是一个旋转数组
*
* 旋转后的数组看上去似乎也是相对有序的，只不过分为了两个数组 {3，4，5} 与{1，2}
* 相对有序的数组，我们使用二分法查找
* head 指向元素 3  tail指向 元素2
* mid=(head+tail)/2 ==2  mid指向5
*
*1.mid所指向的大于tail所指向的 所以mid是在第一个数组里边
* head=mid
*
*2.如果 mid所指向的小于tail所指向的 mid是在第二个数组里边
*tail=mid
*
* 当然也可以和head相比
*
* 但是也有其他的情况例如:{1,0,1,1,1}
* */
public class RotateArray {
    public static void main(String[] args) {
        int array[]={3,4,5,1,2};
        int array1[]={1,2,0,1,1,1};
        int array2[]={1,2,3,4,5};

    }
    public static int rotateArray(int [] array){
        int head=0;
        int tail=array.length-1;
        int mid=(head+tail)/2;
        if (array[head]<array[tail]) return array[0];
        while(head<tail){
            if (tail-head==1){
                return array[tail];
            }
            if (array[mid]>array[tail]){
                head=mid;
            }else {
                tail=mid;
            }
            mid=(head+tail)/2;
        }
        return -1;

    }

}
