package leetcode;

public class leetcode824 {
    public void toGoatLatin(String S) {
        int aanum=1; //记录单词数并且记录在每一个单词后添加aa的个数
        int manum=0; //记录每一个单词要的加的ma的个数
        char temp=' '; //记录首字母是否为辅音
        boolean is=false;
        String result=" "; //结果字符串
        char [] als=S.toCharArray();
        for (int j = 0; j < als.length; j++) {
            if (als[j]==' '){
                for (int i = 0; i <aanum ; i++) {
                    result.concat("aa");
                }
                for (int i = 0; i < manum; i++) {
                    result.concat("ma");
                }
                if (is) result.concat(""+temp);
                result.concat(" ");
                is=false;
                manum=0;
                aanum++;
            }else  if (als[j]=='a'||
                    als[j]=='e'||
                    als[j]=='i'||
                    als[j]=='o'||
                    als[j]=='u'){
                manum++;
                result.concat(""+als[j]);
            }else {
                if (j==0||als[j-1]==' '){
                    temp=als[j];
                    is=true;
                }
                result.concat(""+als[j]);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        (new leetcode824()).toGoatLatin("i speak goat latin");
    }
}
