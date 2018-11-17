package AlgorithmTest;
/*
* 题目：寻找数组里边出现次数大于数组长度一半的元素 时间复杂度为O(n)
* 思路:
* 删除 数组中相邻的不相同的元素：例如：
* {1,2,3,2,5,2,2,6,2,2,2,3,2}
* 1.第一种思路
 * 删除1，2 删除3，2 删除5，2 删除6，2  最后剩下的就是要寻找的数
 * 但是当出现：4，4 的时候失败
 * 这种算法太局部
 * 2，第二种思路:
 * 每次取出两个不同的数，剩下的数字中重复出现的数字肯定比其他数字多，
 * 删除这两个数，剩下的最高频的数还是大于50%
 * 3.第三种思路：
 * 作为出现次数大于数组长度一半的数，那么这个数组在排序后的中位数就是我们要的结果
 * 那么问题转化到：如果求一个无规则数组的中位数呢？
 * 我们使用过快排，所以：
 * 选定一个数进行第一次的分割，大的放在右边，小的放在左边，如果数组的索引小于n/2时，说明中位数在其右边，
 * 相反，则在其左边
 * 接下来从右边/左边去查找直到其索引是n/2
 * 此种算法的关键又转移到了如何对一个数组进行切割
 *
* */
public class FindMostDataOfArray {

    public static void main(String[] args) {
        int [] array={1,2,3,2,2,2,2,5,2,6,2,2,2,3,5,2,4,4,4};
     //   findMostDataOfArray(array);
        findMostDataOfArrayS(array);
    }
    /*
    * 经测试是失败的算法
    * */
    public static void findMostDataOfArray( int [] array){
        int curr=0;
        int next=curr+1;
        int theNum=0;
        for (int i=0;i<array.length;i++){
            if (theNum>=array.length-1||curr>array.length-1||next>array.length-1){
                break;
            }
            if (array[curr]!=array[next]){
                 curr+=2;
                 next=curr+1;
            }else{
                theNum=curr;
                curr++;
                next=curr+1;
            }
        }
        System.out.println(array[theNum]+" "+theNum);
    }
    /*
     * 成功的算法
     * */
    public static void findMostDataOfArrayS( int [] array){
        int findNum = 0; // 出现次数超过一半的数；
        int count = 0; // 只要最终count > 0，那么对应的findNum就是出现次数超过一半的数；

        // 循环过程中，i每增加一次，就相当于把i之前的所有元素（除了满足“findNum == arr[i]”条件的arr[i]，这些对应元素用“count++”来标记）都抛弃了，但是之后每当执行一次“ count-- ”时，又会从前面这些已保留的且等于findNum的元素中删除一项，直到count == 0，再重选findNum；
        for (int i = 0; i < array.length; i++)
        {
            if (count == 0) // count为0时，表示当前的findNum需要重选；
            {
                findNum = array[i];
                count = 1;
            }
            else
            {
                if (findNum == array[i])
                    count++;
                else
                    count--;
            }
        }
        System.out.println(findNum);

    }
}
