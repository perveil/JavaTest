package AlgorithmTest;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 题目一：reverse 旋转数字
* 题目二：字符串转整数
* 题目三：判断是不是数字(本解法限制了不可以出现 "+" "-")
*
* */
public class NumTest {
    public static void main(String[] args) {

        System.out.println(isNumber("."));
    }
    public static int reverse(int x) {
        boolean flag= false;
        if(x <0) flag =true;
        if(new Integer(x)>Integer.MAX_VALUE ||new Integer(x)<Integer.MIN_VALUE){
            return 0;
        }
        x=Math.abs(x);
        char [] aimArray=new String(""+x).toCharArray();
        String result="";
        for (int i = aimArray.length-1; i >=0; i--) {
            result+=aimArray[i];
        }
        if(new Integer(result)>Integer.MAX_VALUE ||new Integer(result)<Integer.MIN_VALUE){
            return 0;
        }
        int resultI=flag? -new Integer(result):new Integer(result);
         System.out.println(resultI);
        return resultI;


    }
    public static int myAtoi(String s) {
        if (s.equals("")){
           return  0;
        }
        char [] aimArray=s.toCharArray();
        char flag=' ';
        boolean  Is=false;
        boolean begin=false;
        boolean Ischange=false;
        String result="";
        for (int i = 0; i <aimArray.length ; i++) {
            if(!begin){
                if (aimArray[i]==' ') {
                    continue;
                }else{
                    try{
                        Integer temp=Integer.valueOf(aimArray[i]+"");
                        if (temp<=9&&temp>=0){
                            result+=aimArray[i];
                            begin=true;
                            Ischange=true;
                        }else{
                            break;
                        }
                    }catch (NumberFormatException e){
                        if (aimArray[i]=='+'||aimArray[i]=='-'){
                            flag=aimArray[i];
                            Is=aimArray[i]=='+'? false:true;
                            begin=true;
                            Ischange=true;
                            continue;
                        }
                        return 0;

                    }

                }
            }else{
                if (aimArray[i]=='+'||aimArray[i]=='-'){
                    if (Ischange){
                        break;
                    }else{
                        flag=aimArray[i];
                        Is=aimArray[i]=='+'? false:true;
                    }
                }else {
                    try{
                        Integer temp=Integer.valueOf(aimArray[i]+"");
                        if (temp<=9&&temp>=0){
                            result+=aimArray[i];
                        }else{
                            break;
                        }
                    }catch (NumberFormatException e){
                        if (result.length()==0){
                            return  0;
                        }else{
                            break;
                        }

                    }
                }

            }
        }
        try{
            Integer _result=new Integer(result);
            return !Is?_result: -_result;
        }catch (NumberFormatException e){
            if(result==""){
                return 0;
            }else{
                return Is?-(Integer.MAX_VALUE+1):Integer.MAX_VALUE;
            }
        }
    }
    public static boolean isNumber(String s){
        s=s.trim(); //删除两边的空格
        if (s.length()==0){
            return false;
        }
        int eN=0;
        int qN=0;
        char [] array=s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i]==' '){
                return false;
            }
            try{
                Integer temp =Integer.valueOf(array[i]+"");
            }catch (NumberFormatException e){
                if(array[i]=='.'){
                    if(i+1<=array.length-1){
                        if(array[i+1]=='e'){
                            return false;
                        }
                    }
                    if(qN==0){
                        qN=1;
                        if (array.length==1){
                            return false;
                        }
                        continue;
                    }else{
                        return false;
                    }
                }else{
                    if (array[i]=='e'){
                        if(i+1<=array.length-1){
                            if(array[i+1]=='.'){
                                return false;
                            }
                        }
                        if(eN==0){
                            eN=1;
                            if (array.length==1||(i-1)<0||(array[0]=='0'&&(i+1)>array.length-1)||(i+1)>(array.length-1)){
                                return false;
                            }else{
                                continue;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }

            }

        }
        return true;

    }
    public static boolean isNumberT(String s) {
        s = s.trim();
        int len = s.length();
        if (0 == len) return false;

        boolean hasE = false, hasDot = false, hasDigit = false, hasFirst = false;

        for (int i = 0; i < len; i++)
        {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasFirst = hasDigit = true;
                continue;
            }

            switch (c) {
                case 'e':
                    if (hasE || !hasDigit) return false;
                    hasE = true;

                    hasDot = true;
                    hasFirst = hasDigit = false;
                    break;
                case '.':
                    if (hasDot) return false;
                    hasDot = true;
                    hasFirst = true;
                    break;
                case '+':
                case '-':
                    if (hasFirst) return false;
                    hasFirst = true;
                    break;
                default:
                    return false;
            }
        }

        return  hasDigit;
    }

}
