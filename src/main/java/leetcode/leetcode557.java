package leetcode;

public class leetcode557 {
    public String reverseWords(String s) {
        int head=0;
        int tail=0;
        char[] chars=s.toCharArray(); //character Array
        while (tail<chars.length){
            //寻找各个单词的尾侧
            while(tail<chars.length&&chars[tail]!=' '){
                tail++;
            }
            tail--; //回退一格
            //开始逆转
            int i=head;
            int j=tail;
            for(;i<=(tail+head)/2&&j>(tail+head)/2;i++,j--){
                char temp=chars[i];
                chars[i]=chars[j];
                chars[j]=temp;
            }
            //逆转结束
            head=tail+2;
            tail=head;
        }
        String res=String.valueOf(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        new leetcode557().reverseWords("Let's take LeetCode contest");
    }
}
