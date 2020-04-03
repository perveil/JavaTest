package leetcode;

public class leetcode8_字符串转数字 {
    public int myAtoi(String str) {
        char[] chars=str.toCharArray();
        int n=chars.length;
        int idx=0; //遍历字符的索引
        /*
        * 去除空格
        * */
        while (idx<n&&chars[idx]==' '){ //去除前导空格 trim函数
            idx++;
        }
        if (idx==n){
            return 0;
        }
        /*
        * 确定符号
        * */
        boolean negative=false; //是否是一个负数
        if (chars[idx] == '-') {
            negative=true;
            idx++;
        }else  if (chars[idx]=='+'){
            idx++;
        }else if (!Character.isDigit(chars[idx])){ //不合格的字符直接返回
            return 0;
        }
        /*
        *符号之后的数字
        * */
        int res=0;
        while (idx<n&&Character.isDigit(chars[idx])){ //当一个数字的后边存在非法字符的时候，直接返回之前的数值
            int digit=chars[idx]-'0';
            if (res>(Integer.MAX_VALUE-digit)/10){ //此时超出表示范围
                return !negative?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=res*10+digit;
            idx++;
        }
        return negative?-res:res;
    }
}
