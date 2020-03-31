package leetcode;

import java.util.ArrayList;

/*
* 数学解法
* 最后的数组中，仅剩下一个元素就是目标元素：此时目标元素的index=0
* 从index 0 开始反推m步，(0+m)%上一轮剩余的数字个数2=index1
* 从index1 开始反推m步， （index1+m）%3
* ...
* 反推到数组元素个数为n时计算结果为所求
* */
public class interiview62_约瑟夫环 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
    /*
    * 链表解法
    * */
    public int lastRemainingOflinkedList(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        new interiview62_约瑟夫环().lastRemaining(5,3);
    }
}
