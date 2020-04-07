package leetcode.dp;

public class leetcode338_比特位计数 {
    public int[] countBits(int num) {
        if (num==0) return  new int[]{0};
        int []res=new int[num+1];
        res[0]=0;
        res[1]=1;
        for (int i = 2; i <=num ; i++) {
            if (i%2==0) res[i]=res[i/2];  //i偶数时，其值为i/2 的二进制向左移动一位
            else        res[i]=res[i-1]+1; //i为奇数时，其值为i-1 的偶数的最右位加 1
        }
        return res;
    }
}
