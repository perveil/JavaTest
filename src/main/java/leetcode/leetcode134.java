package leetcode;

public class leetcode134 {
    public static void main(String[] args) {
        System.out.println(
            new leetcode134().canCompleteCircuit(new int[]{
                    3,1,1
            },new int[]{
                    1,2,2
            })
        );
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i <gas.length ; i++) {
            int allGas=0; //所有的汽油，初始为0
            for (int j = i; j <=gas.length ; j++) {
                if (j==gas.length){
                    if (i==0&&allGas>=0) return i;
                    for (int k = 0; k <i; k++) {
                        allGas+=gas[k]-cost[k];
                        if (allGas<0) break;
                        if (k==i-1&&allGas>=0) return i;
                    }
                }
                if (j<gas.length){
                    allGas+=gas[j]-cost[j];
                    if (allGas<0) break;
                }
            }
        }
        return -1;
    }
}
