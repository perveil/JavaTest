package SwordPointToOffer;
/*
* 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy
* */
public class problem04 {
    public String replaceBlank(String string) {
        StringBuilder temp=new StringBuilder();
        char[] chars=string.toCharArray();
        for (char c:
             chars) {
            if (c==' ') temp.append("%20");
            else temp.append(c+"");
        }
        return temp.toString();
    }

    public static void main(String[] args) {
       String str= new problem04().replaceBlank("we are happy.");
       System.out.println(str);
    }
}
