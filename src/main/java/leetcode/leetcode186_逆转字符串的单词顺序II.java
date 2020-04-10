package leetcode;

public class leetcode186_逆转字符串的单词顺序II {
    /*
    * 两端没有空余空格，两个单词只有一个空格，不能使用任何空间在原地进行操作
    *
    * 思路：先逆转整个字符串，在逆转每一个单词
    * */
    public void reverseWords(char[] s) {
        int len=s.length;
        if (len==0) return;
        reverseWord(s,0,len-1);
        int start=0,end=len-1;
        while (start<len){
            end=start; //移动end指针到字符串的最后
            while(end+1<len&&s[end+1]!=' '){
                end++;
            }
            reverseWord(s,start,end);
            start=end+2; //跨过空格
        }
    }
    public void reverseWord(char[] s,int start,int end){
        char temp;
        while(start<end){
            temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }

}
