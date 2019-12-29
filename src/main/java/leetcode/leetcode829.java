package leetcode;

public class leetcode829 {

    //暴力公式法
    public int consecutiveNumbersSum(int N) {
        int result=1;
        for (int i = 1; i <=N/2; i++) { //从i开始加，i i+1 i+2 i+3....i+j
            for (int j = 1; j <=Math.sqrt(2*N); j++) {
                if ((j+1)*1.0*(i+(j*1.0)/2)==N*1.0){
                    result++;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        new leetcode829().consecutiveNumbersSum(247031);
    }
}
