package AlgorithmTest;

import java.util.HashMap;
import java.util.Map;

/*
*判断 删除一个元素后是否是回文字符串
* */
class Solution {
    public static void main(String[] args) {
      System.out.println(validPalindrome("aba"));
    }
    public static boolean validPalindrome(String s) {
        if(s.length()<1){
            return true;
        }
        if(isPalindrome(s)){
            return true;
        }else{
            for(int i=0;i<s.length();i++){
                if(i==0){
                    if(isPalindrome(s.substring(1,s.length()))){
                        return true;
                    }
                    continue;
                }else if(i==s.length()-1){
                    if(isPalindrome(s.substring(0,s.length()-1))){
                        return true;
                    }
                    return  false;

                }else{
                    if(isPalindrome(s.substring(0,i)+s.substring(i+1,s.length()))){
                        return true;
                    }
                    continue;
                }
            }
            return false;

        }

    }
    public  static boolean isPalindrome(String s) {
        boolean flag=s.length()%2!=1? false:true; //奇数偶数
        int temp=0;
        temp=s.length()/2;
        if(flag){ //奇数
            return  s.substring(0,temp).equals(new String(new StringBuilder(s.substring(temp+1,s.length())).reverse()));
        }else{  //偶数
            return s.substring(0,temp).equals(new String(new StringBuilder(s.substring(temp,s.length())).reverse()));
        }
    }
    public boolean judgeCircle(String moves) {
        Map<String,Integer> desMap= new HashMap<String,Integer>();
        desMap.put("L",0);
        desMap.put("U",0);
        desMap.put("D",0);
        desMap.put("R",0);
        char [] moveCharA=moves.toCharArray();
        for(int i=0;i<moveCharA.length;i++){
            switch (moveCharA[i]){
                case 'L':
                desMap.put("L",desMap.get("L")+1);
                break;
                case 'R':
                desMap.put("R",desMap.get("R")+1);
                break;
                case 'U':
                desMap.put("U",desMap.get("U")+1);
                break;
                case 'D':
                desMap.put("D",desMap.get("D")+1);
                break;
                default:
                    return false;
            }
        }
        if(desMap.get("L").equals(desMap.get("R"))&&desMap.get("U").equals(desMap.get("D"))){
            return true;
        }
        return false;

    }
}
