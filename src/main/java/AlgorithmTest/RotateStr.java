package AlgorithmTest;
/*
*  题目一：判断是否为回文
*  题目二：验证回文字符串
*
* */
public class RotateStr {
    public static void main(String[] args) {
           System.out.println(isPalindrome("abba"));
    }
    public static boolean Test1(int aim){
        char [] Array1=new String(aim+"").toCharArray();
        String result="";
        for (int i = Array1.length-1; i >=0 ; i--) {
            result+=Array1[i];


        }
        return new String(aim+"").equals(result);
    }
    public static boolean isPalindrome(String s) {
        s=s.replaceAll(" ","").replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); //替换所有空格
        boolean flag=s.length()%2!=1? false:true; //奇数偶数
        int temp=0;
        temp=s.length()/2;
        if(flag){ //奇数
            return  s.substring(0,temp).equals(new String(new StringBuilder(s.substring(temp+1,s.length())).reverse()));
        }else{  //偶数
            return s.substring(0,temp).equals(new String(new StringBuilder(s.substring(temp,s.length())).reverse()));
        }
    }
}
