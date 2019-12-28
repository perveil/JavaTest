package leetcode;
/*
* KMP 算法
* */
public class leetcode28 {
    public static void main(String[] args) {

        new leetcode28().strStr("mississippi","issip");
    }
    public int strStr(String haystack, String needle) {
        int length=needle.length();  //结果
        int result=0;
        boolean flag=false;
        char [] array1=haystack.toCharArray(); //i
        char [] array2=needle.toCharArray();  //j
        int i=0,j=0;
        while (j <array2.length&&i < array1.length) {
            if (array1[i]==array2[j]){
                if(!flag) result=i;
                i++;
                j++;
                length--; //递减s
                flag=true;
            }else {
                i=i-j+1;
                j=0;
                length=needle.length();
                flag=false;
            }
        }
        return length==0?result:-1;
    }
}
