package leetcode.bitoperation;
/*
* 除了两个数，其他数都出现了两次，求这两个数
* 由于两个数是不同的，那么两个数的异或一定大于0，即存在x位为1
* 此时需要把这两个数区分开，就需要把整个数组分为两组，一组的x位为1，一组的x位为0
* 如果找到x位呢？
*   做法:
*     1.k=s&(-s) //找出s从右往左数的第一个1
*     2.Integer.highestOneBit(),找出s从左往右数的第一个1
* */
public class leetcode260_只出现一次的数字III {
    public int[] singleNumber(int[] nums) {
        int s=0;
        for (int i:
             nums) {
            s^=i;
        }
        int k=s&(-s);
        int []res=new int[2];
        for (int i:nums){
            if ((i&k)==0){
                res[0]^=i;
            }else {
                res[1]^=i;
            }
        }
        return res;
    }
}
