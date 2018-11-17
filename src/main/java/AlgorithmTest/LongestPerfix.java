package AlgorithmTest;
/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

* */
public class LongestPerfix {
    public static void main(String[] args) {

    }
    public static String longest(String[] array){
        int result=0;
        char temp=array[0].toCharArray()[result]; //以第一个为参照物
        boolean isRight=true;
        while(isRight){
            for (int j = 0; j <array.length ; j++) {
                if (array[j].toCharArray()[result]==temp){
                    continue;
                }else{
                    isRight=false;
                    break;
                }
            }
            if (isRight){
                result++;
                temp=array[0].toCharArray()[result];
            }else{
                break;
            }
        }





        return array[0].substring(0,result);

    }
}
