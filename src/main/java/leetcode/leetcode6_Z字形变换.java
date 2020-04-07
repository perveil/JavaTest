package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*  Z 字形排列成给定的行数：
*  思路：
*
*
* */
public class leetcode6_Z字形变换 {
    public static void main(String[] args) {
        System.out.println(createZ("ABCDEFGHIJKEFSDRX",5));
    }
    public static String createZ(String s,int numRows){
        if (numRows == 1) return s; //只有一行则直接返回

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false; //向下或者向上

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
