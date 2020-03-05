package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode640 {
    public String solveEquation(String equation) {
        String []lr=equation.split("=");
        int lhs=0,rhs=0;// lhs代表左侧x的系数，rhs代表右侧整数
        for (String x:
             breakIt(lr[0])) {
            if (x.indexOf("x")>=0){ //如果式子是nx
                lhs+=Integer.parseInt(coeff(x));
            }else{
                rhs-=Integer.parseInt(x);
            }
        }
        for (String x:
                breakIt(lr[1])) {
            if (x.indexOf("x")>=0){ //如果式子是nx
                lhs-=Integer.parseInt(coeff(x));
            }else{
                rhs+=Integer.parseInt(x);
            }
        }
        if (lhs==0){
            if (rhs==0)
                return "Infinite solutions";
            else
                return "No solution";
        }
        return "x="+rhs/lhs;
    }
    //
    public String coeff(String x) {
        if (x.length()>1&&x.charAt(x.length()-2)>='0'&&x.charAt(x.length()-2)<='9'){
            //x.charAt(x.length()-2)>'0'&&x.charAt(x.length()-2)<'9' 是为了处理+x/-x的意外情况
            return x.replace("x","");
        }
        return x.replace("x","1");
    }
    // 拆解字符串
    public List< String > breakIt(String s) {
        List<String> res=new ArrayList<>(); //拆解字符串
        String r=""; //过渡字符串
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)=='+'||s.charAt(i)=='-'){ //如果遇见符号说明是上一个子式录入完毕
                if (r.length()>0)
                    res.add(r);
                r=""+s.charAt(i);  // 加上符号
            }else{
                r+=s.charAt(i);
            }
        }
        res.add(r);
        return res;
    }

    public static void main(String[] args) {
        new leetcode640().solveEquation("99x=99");
    }
}
