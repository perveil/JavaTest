package AlgorithmTest;
/*
*
* */
import java.util.HashSet;
import java.util.Set;

public class PositionalCel {
    public static void main(String[] args) {
          int Array []={108,121,9,85,27};
          Cel(Array);
    }
    public static int Cel(int [] Array){
        Set<Integer> result=new HashSet<>();
        int len=Array.length;
        int temp=0;
        //问题转化为找一个数组的连续全排列
        for (int i=1;i<=len;i++){
            temp= CelNum(Array,i);
            for (int j=0;j<temp;){
                if (j+i-1>len-1){
                       int Cel=Array[j];
                       for(int k=j;k<len-1;k++){
                          Cel=Cel|Array[k];

                       }
                       result.add(Cel);
                }else{
                    int Cel=Array[j];
                    for(int k=j;k<=j+i-1;k++){
                        Cel=Cel|Array[k];
                    }
                    result.add(Cel);
                    j++;
                }

            }
        }
        System.out.println(result);
        return result.size();

    }
    public static int CelNum(int [] Array,int len){
        int result=0;
        int length=Array.length;
        for (int i=0;i<length;i++) {
            if (i + len <= length) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
