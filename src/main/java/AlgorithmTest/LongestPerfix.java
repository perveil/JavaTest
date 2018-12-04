package AlgorithmTest;
/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

* */
public class LongestPerfix {
    public static void main(String[] args) {
     String [] aim ={
             "a","a"
     };
     System.out.println(longest(aim));
    }
    public static String longest(String[] strs){
        if(strs.length<=1){
            if(strs.length==0){
                return "";
            }
            return strs[0];
        }
        int result=-1;
        if (strs[0].length()==0){
            return "";
        }
        char temp=strs[0].toCharArray()[0]; //以第一个为参照物
        boolean isRight=true;
        while(isRight){
            for (int j = 1; j <strs.length ; j++) {
                if(strs[j].length()<=0){
                    return "";
                }
                if (result+1<strs[j].length()&&strs[j].toCharArray()[result+1]==temp){
                    continue;
                }else{
                    isRight=false;
                    break;
                }
            }
            if (isRight){
                if (result+1>=strs[0].toCharArray().length){
                    return strs[0].substring(0,result+1);
                }
                result++;
                temp=result+1<strs[0].length()?strs[0].toCharArray()[result+1]:' ';
            }else{
                break;
            }
        }
        return strs[0].substring(0,result+1);

    }
}
