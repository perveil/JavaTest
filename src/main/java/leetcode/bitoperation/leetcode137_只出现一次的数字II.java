package leetcode.bitoperation;

/*
* 考虑每一位
*  泛化
*    1.如果数组中除了x都出现了奇数次，那么采用每一位1的个数%1
*    2.如果数组中除了x都出现了偶数次，那么采用直接异或，异或之后留下的就是x的每一位
* */
public class leetcode137_只出现一次的数字II {
    /*
     * 逐位考虑：
     * 考虑出现了3次的数字的二进制，每一位上的1的个数一定是3的倍数
     * 如果出现了一次的数字的在该位是1，那么整个数组在该位上1的个数%3=1
     *
     * 所以我们逐步求32位上1的个数%3==1的位置来求解x
     * */
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i <32 ; i++) {
            int count=0; //i位上1的个数
            for (int x:
                    nums) {
                count+=(x>>i)&1; //求x 在i是否为1
            }
            res |=(count%3)<<i;  // | 运算 合并 i位上的1
        }
        return res;
    }
}
