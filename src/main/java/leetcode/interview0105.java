package leetcode;

public class interview0105 {
    /*
    * first -->second
    * 情况分三种：
    *     1.替换 first.length()==second.length()
    *     2.删除 first.length()=second.length()+1
    *     3.添加 first.length()+1=second.length()
    * */
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) return true;
        int len1 = Math.max(first.length(), second.length());
        int len2 = Math.min(first.length(), second.length());
        if (len1 - len2 > 1) return false;
        if (len1 != first.length()) { //交换字符串，使得长字符串为 first
            String tmp = first;
            first = second;
            second = tmp;
        }
        int count = 0;
        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i))
                    count++;
                if (count > 1) return false;
            }
        } else {
            //长短字符串 只允许有一处不匹配 例如 pales与pale(删除尾)  pacb与pab(删除中间)  pale与ale(删除头)
            for (int i = 0, j = 0; i < len2; j++) {
                if (count > 1) return false;
                if (first.charAt(j) != second.charAt(i)) {
                    //不相同只移动长字符串的指针，把for改成while循环应该好些
                    count++; //不对应的地方
                    continue;
                }
                i++;
            }
        }
        return true;
    }
}
