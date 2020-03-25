package leetcode;

public class leetcode65_有效数字 {
    public boolean isNumber(String s) {
        s = s.trim();        //去除两边空格
        int len = s.length();
        if (0 == len) return false;
        /*
          hasE 是否含有指数
          hasDot 是否含有小数点
          hasDigit 是否含有数字
          hasFirst 符号之前是否有数字
         */
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
                    if (hasE || !hasDigit) return false; //有指数的前提下，前边没有数字
                    hasE = true;
                    hasDot = true; //指数表示只能表示为 e12 不能e12.0
                    hasFirst = hasDigit = false; //开始处理指数后的数字
                    break;
                case '.':
                    if (hasDot) return false; //指数之前不能有两个小数点，
                    hasDot = true;
                    hasFirst = true; //指数前已经有了数字
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
