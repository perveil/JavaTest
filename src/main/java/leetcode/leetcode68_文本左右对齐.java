package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode68_文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        List<List<Integer>> fenzuList=new ArrayList<>();
        /*
        * 将words 分组
        * */
        List<Integer> list=new ArrayList<>();  //分组list
        int curlen=0;
        int space=0;
        for (int i = 0; i <words.length ; i++) {
            if (curlen+space+words[i].length()<=maxWidth){
                list.add(i);
                space++;
                curlen+=words[i].length();
            }else {
                fenzuList.add(list);
                list=new ArrayList<>();
                list.add(i);
                curlen=words[i].length();
                space=1;
            }
            if (i==words.length-1&&list.size()>0){
                fenzuList.add(list);
            }
        }
        for (List<Integer> l: fenzuList) {
            int len=0;
            for (Integer i: l) {
                len+=words[i].length(); //计算出字符所占得长度
            }
            int spacenum=maxWidth-len;  //此时空格数
            int num1=(int)Math.floor( spacenum/((l.size()-1)==0?1:(l.size()-1))); //整除后的空格数
            if (spacenum%((l.size()-1)==0?1:(l.size()-1))!=0){
                num1++;
            }
            int curnum=num1;
            StringBuilder temp=new StringBuilder();
            for (Integer i: l) {
                temp.append(words[i]).append(retrunVoidStr(curnum));
                spacenum-=curnum;
                curnum=spacenum>num1?num1:spacenum;
            }
            res.add(temp.toString());
        }
        return res;
    }
    String retrunVoidStr(int num){
        StringBuilder s=new StringBuilder();
        for (int i = 0; i <num ; i++) {
            s.append(" ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        new leetcode68_文本左右对齐().fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        },16);
    }
}
