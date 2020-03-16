package leetcode;

public class Interview0106 {
    public String compressString(String S) {
        char [] chars=S.toCharArray();
        char cur=chars[0];
        int num=1;
        StringBuilder res=new StringBuilder();
        for (int i = 1; i <chars.length ; i++) {
            if (chars[i]==cur){
                num++;
            }else {
                res.append(""+cur+""+num);
                cur=chars[i];
                num=1;
            }
        }
        res.append(""+cur+""+num);

        return res.toString().length()>=S.length()?S:res.toString();
    }
}
