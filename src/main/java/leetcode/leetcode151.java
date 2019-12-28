package leetcode;

public class leetcode151 {
    public static void main(String[] args) {
        System.out.println(
         new leetcode151().reverseWords("the sky is blue")
        );
    }
    public String reverseWords(String s) {
        String [] resultA= s.replaceAll("\\s{2,}", " ").trim().split(" ");
        String result="";
        for (int i=resultA.length-1;i>=0;i--) {
            result+= resultA[i]+" ";
        }
        return result.trim();
    }

}
