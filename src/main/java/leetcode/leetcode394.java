package leetcode;

import java.util.Stack;

/*
* 拓展类型括号匹配:从里向外扒
* */
public class leetcode394 {
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        int multi=0;//记录每一个字符的重复次数
        Stack<Integer> num_Stack=new Stack<>(); //次数栈
        Stack<String> str_Stack=new Stack<>();  //字符栈
        for ( Character c: s.toCharArray()) {
            if (c=='['){
                num_Stack.push(multi); //重复次数入栈
                str_Stack.push(res.toString()); //[ 之前的字符
                multi=0;
                res=new StringBuilder(); //过渡元素
            }else if(c==']'){ //此时的res 是括号中的元素，需要倍乘
                StringBuilder tmp = new StringBuilder();
                int cur_num=num_Stack.pop();
                for (int i = 0; i < cur_num; i++) {
                    tmp.append(res);
                }
                res=new StringBuilder(str_Stack.pop()+tmp);
            }else if (c >= '0' && c <= '9'){ //数字 也可能是多位数字
                multi=multi*10+Integer.parseInt(c+"");//处理多位数字
            }else{
                res.append(c);
            }
        }
        return res.toString();

    }
}
