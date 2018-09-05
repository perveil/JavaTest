package AlgorithmTest;
/*
* 题目一:输入一个已经按升序排序的数组Array，和一个数字N，得出数组中和是数字的元素n1 n2,m1 m2.....
* 例如：输入[1 2 4 7 11 15] 15 输出4 11
*
* 题目二：在M个数中寻找k个最小的数
* 例如：输入[10,-9,1,2,11,13]  2   输出 -9 1
* 思路是
* 1.先在数组起始位置划定k大小的区域，
* 2.然后去找到K中最大的数M， findMax()找到并且定位
* 3.然后将M与其他数相比，如果大于M，不变，如果小于，与M 交换位置，
* 4.重复2步骤，知道数组末尾
*
* 题目三：两个排序的数组A和B 分别含有m和n个数，找到两个排序数组的中位数
* 具体思路不重复说了：https:/www.jianshu.com/p/7c990b12a82a
* 简单说下思路:
* 由于是有序数组，假如我们通过切割两个数组得到另外的两个数组
* 这两个数组满足以下两个条件
* 1.长度相等
* 2.一个数组A中的所有值小于数组B中的所有值，B中的所有值大于A中所有值，此时中位数已经呼之欲出了
* 3.问题又转化到：找一个数组的满足以上两个条件的临界值
* */
public class Aarryesc {
    public static void main(String[] args) {
        int Array []={1,4,3,7,11,15};
        int sum =15;
        toResultForProblem(Array,15);
        int Array2[]={10,3,1,2,11,13};
        int num=2;
        toResultForSecondProblem(Array2,num);

        int Array3 []={1,2,3,4,5,6};
        int Array4[]={4,5};
        System.out.print(toResultForThirdProblem(Array3,Array4));


    }
    public static void toResultForProblem(int [] Array,int sum){
        /*
        * 从两边开始寻找 head=0 tail=Array.length()-1
        * */
        int head=0;
        int tail=Array.length-1;
        boolean result=true;
        while(Array[head]+Array[tail]!=sum){
            if (Array[head]+Array[tail]>sum){
                tail--;
            }else{
                head++;
            }
            /*
            * 属于找不到
            * */
            if (tail-head==1){
                result=false;
                break;
            }
        }
        if (result){
            System.out.println(Array[head]+" "+Array[tail]);
        }else{

        }


    }
    public static void toResultForSecondProblem(int [] Array,int num){
       int current=num;  //遍历时的索引
       int K=num; //目标数组容量不会变
       while (current <Array.length){
           int Maxindex=findMax(Array,num)[0];
           int max=findMax(Array,num)[1];
           if (Array[current]<max){
               Array[Maxindex]=Array[current];
           }
           current++;
       }
       for (int i=0;i<num;i++){
           System.out.print(Array[i]+" ");
       }
    }
    public static int[] findMax(int [] Array,int num){
        int max=Array[0];
        int index=1;
        int Maxindex=0;
        while(index<num){
            if (max<Array[index]){
                max=Array[index];
                Maxindex=index;
            }
            index++;
        }
        return new int[]{Maxindex, max};
    }
    public static double toResultForThirdProblem(int [] Array1,int []Array2){
     if (Array1.length>Array2.length){
         int[][] result=changeArrayPosition(Array1,Array2);
         Array1=result[1];
         Array2=result[0];
     }
     int m=Array1.length;
     int n=Array2.length;
     int imin=0,imax=m,half_len=(m+n)/2,i = 0,j=0,max_of_left=0,min_of_right=0;
     while(imin<=imax){
         i=(imin+imax)/2; //使用了二分查找
         j=half_len-i;  //此时左右两边的数组的宽度相同
         if (i<m&&j>0&&Array2[j-1]>Array1[i]){
             imin=i+1;
         }else if (i>0&&j<n&&Array1[i-1]>Array2[j]){
             imax=i-1;
         }else{
             if (i==0) max_of_left=Array2[j-1];
             else if (j==0) max_of_left=Array1[i-1];
             else max_of_left=Array1[i-1]>Array2[j-1]?Array1[i-1]:Array2[j-1];
             break;

         }
     }
     if ((m+n)%2==1) return max_of_left;
     if (i==m) min_of_right=Array2[j];
     else if (j==n) min_of_right=Array1[i];
     else min_of_right=Array1[i]>Array2[j]?Array2[j]:Array1[i];

     return (min_of_right+max_of_left)/2.0;

    }
    public static int [][] changeArrayPosition(int [] Array1,int []Array2){
        return new int[][]{Array1,Array2};

    }
}
