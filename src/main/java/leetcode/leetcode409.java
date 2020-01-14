package leetcode;

import java.util.HashMap;

public class leetcode409 {
    /*
    * leetcode 409 组成最长回文串
    * */
    public int longestPalindrome(String s) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        int result=0;
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch+"")) map.put(ch+"",map.get(ch+"")+1); //计数加+1
            else map.put(ch+"",1); //计数1
        }
        boolean iscontainOdd=false;
        for (String str:map.keySet()) {
            if (map.get(str)%2==0) result+=map.get(str);
            else {
                result+=(map.get(str)-1);
                iscontainOdd=true;
            }
        }
        return iscontainOdd?result+1:result;
    }
    /*
    * leetcode 42 验证回文串
    * */
    public boolean isPalindrome(String s) {
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
    /*
    * leetcode 564  寻找最近的回文数
    *  难点在于如何处理Integer的溢出问题
    * 贪心法 超时
    * */
    public String nearestPalindromic(String n) {
        int aim=Integer.parseInt(n);
        int bigger=aim+1;
        int smaller=aim-1;
        for (int j = smaller; j >=0 ; --j) {
            if (isPalindrome(j+"")){
                smaller=j;
                break;
            }
        }
        for (int i = bigger;; i++) {
            if (isPalindrome(i+"")){
                bigger=i;
                break;
            }

        }
        return aim-smaller>bigger-aim?bigger+"":smaller+"";
    }

    public static void main(String[] args) {
        System.out.println(
          new leetcode409().nearestPalindromic("123")
        );
    }

}
