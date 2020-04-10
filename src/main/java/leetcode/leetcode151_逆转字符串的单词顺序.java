package leetcode;

public class leetcode151_逆转字符串的单词顺序 {
    public static void main(String[] args) {
        System.out.println(
         new leetcode151_逆转字符串的单词顺序().reverseWords("a good   example")
        );
    }
    /*
    * API 使用 40ms
    * */
    public String APIreverseWords(String s) {
        String [] resultA= s.replaceAll("\\s{2,}", " ").trim().split(" ");
        String result="";
        for (int i=resultA.length-1;i>=0;i--) {
            result+= resultA[i]+" ";
        }
        return result.trim();
    }
    /*
    * 优化 16ms
    * */
    public String reverseWords(String s) {
        s.trim(); //去除两侧多余空格
        char[] chars=s.toCharArray();
        String res="";
        StringBuilder temp=new StringBuilder();
        temp.append(chars[0]); //第一个单词的开头
        for (int i = 1; i<chars.length ; i++) {
            if (chars[i-1]==' '&&chars[i]!=' '){ //遇到某个单词的开头
                res=temp.toString()+" "+res;
                temp=new StringBuilder();
                temp.append(chars[i]);
            }else if (chars[i]!=' '){
                temp.append(chars[i]);
            }
        }
        if (temp.toString().length()>0){
            res=temp.toString()+" "+res;
        }
        return res.trim();
    }
    /*
    * 终极优化 1ms
    * */
    public String freverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }

        return sb.toString();
    }


}
