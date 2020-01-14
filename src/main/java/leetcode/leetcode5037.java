package leetcode;

public class leetcode5037 {
    public int[] getNoZeroIntegers(int n) {
        if(n==2) return new int[]{1,1};
        for (int i=1,j=n-1;i<=j;j--,i++){
            if ((i+"").indexOf("0")==-1 &&(j+"").indexOf("0")==-1){
                return new int[]{
                  i,j
                };
            }
        }
        return  null;
    }
}
