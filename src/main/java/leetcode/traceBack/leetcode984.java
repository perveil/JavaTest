package leetcode.traceBack;

import java.util.ArrayList;
import java.util.List;

public class leetcode984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();
        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                /*
                 ans.charAt(L-1) == ans.charAt(L-2)，出现重复元素
                * */
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)  //控制 先写多的，
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        new leetcode984().strWithout3a3b(1,2);
    }
}
