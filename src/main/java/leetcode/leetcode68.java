package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode68 {
    public static void main(String[] args) {
 //      String [] words = {"What","must","be","acknowledgment","shall","be"};
        String []    words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
       System.out.println(fullJustify(words,20));

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int []length=new int[words.length];
        List<String> result=new ArrayList<>();
        for (int i=0;i<words.length;i++){
            length[i]=words[i].length();
        }
        int startIndex=0;
        int tempIndex=-1;
        int tempNum=0;
        for (;tempIndex+1<words.length;){
            if (tempNum+length[tempIndex+1]<maxWidth){
                tempNum+=length[tempIndex+1];
                tempIndex++;
            }else{
                //缺少判断间距的大小
                result.add(modifyStr(words,tempNum,tempIndex,startIndex,maxWidth));
                startIndex=tempIndex;
                startIndex++;
                tempNum=0;
            }
        }
        result.add(modifyStrT(words,tempNum,tempIndex,startIndex,maxWidth));

        return result;

    }
    public static String modifyStr(String[] words,int num,int end,int start,int maxlength) {
        if (end-start==0){
            String temp="";
            int gap=(maxlength-num);
            for (int i=0;i<gap;i++){
                temp+=" ";
            }
            return  words[start]+temp;
        }
        int gap=(maxlength-num) / (end-start);
        String temp="";
        String result="";
        for (int i=0;i<gap;i++){
          temp+=" ";
        }
        for (int j=start;j<end;j++){
            result+=words[j]+temp;
        }
        return result+words[end];
    }
    public static String modifyStrT(String[] words,int num,int end,int start,int maxlength) {
        String result="";
        for (int i=start;i<=end;i++){
            result+=(words[i]+" ");
        }
        if (result.length()<maxlength){
            String temp="";
            for (int i = 0; i <maxlength-result.length() ; i++) {
                result+=" ";
            }
        }
        return result;
    }
}
