package AlgorithmTest;

public class Backage01 {
    /*
    *  weight 重量集合
    *  value  价值
    *  capCity 最大容量
    *
    *  return 最大价值
    * */
    public int hightestValue(int [] weight,int [] value, int capCity){
        int result=0;
        int [][]dp=new int[weight.length+1][capCity+1];
        for (int i = 0; i < weight.length+1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <capCity+1 ; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <capCity ; i++) {  //容量
            for (int j = 1; j <weight.length ; j++) {  //物品
                if (i-weight[j]>=0 &&dp[j-1][i-weight[j]]+value[j] > dp[j-1][i]){  //有剩余容量且装入后价值增加
                    dp[j][i]=dp[j-1][i-weight[j]]+value[j];
                }
                dp[j][i]=dp[j-1][i];   //无剩余容量或者装入后价值不增加
            }
        }
        return result;


    }
}
