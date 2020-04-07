package leetcode;
public class leetcode1404_将二进制表示减到1的步骤数 {
    /*
    * 暴力解法，超时
    * */
    public int numStepsfail(String s) {
        char[] nums=s.toCharArray();
        int num=0;
        int res=0;
        for (int i = nums.length-1,j=0; i >-1&&j<nums.length; i--,j++) {
            num+=(nums[i]-'0')*Math.pow(2,j);
        }
        while (num!=1){
            if (num%2==0){ //num 是偶数
                num/=2;
            }else {
                num+=1;
            }
            res++;
        }
        return res;
    }
    /*
    * 优化
    * 当末位是0，1110（14）除以二->（111） 就相当于抛弃最后一位的0
    * 当末位是1，1111（15）加1->10000     需要进位+1，
    * 然后由于进位使得末位为0，如果有连续的1 就是连续进位产生连续的0，进位产生的0则是接下来偶数要除以2的个数
    * */
    public int numSteps(String s) {
        char[] nums=s.toCharArray();
        int res=0;
        int i=nums.length-1;
        while (i >0) { //最后一位肯定剩一
            if (nums[i]=='0'){
                res++;
                i--; //末尾元素--
            }else {
                res++; //末位进位加1
                while(i>=0&&nums[i]=='1'){
                    //i 为什么可以=0，1111 加1=10000 此时10000 有4个连续的0，则需要四次除以2
                    res++; //偶数除2 的操作
                    i--; //此时进位之后为0
                }
                if (i>0){
                    nums[i]='1'; //进位最终的结果
                }

            }
        }
        return res;
    }


    public static void main(String[] args) {
        new leetcode1404_将二进制表示减到1的步骤数().numSteps("1111011110000011100000110001011011110010111001010111110001");
    }
}
