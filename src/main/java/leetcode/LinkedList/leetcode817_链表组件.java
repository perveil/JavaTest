package leetcode.LinkedList;
/*
  @Date:2020/4/27 17:11
  @Author:Administrator
*/

import java.util.*;

public class leetcode817_链表组件 {
    public int numComponents(ListNode head, int[] G) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <G.length ; i++) {
            list.add(G[i]);
        }
        int res=0;
        boolean seq=false; //此时连续的组件
        while(head!=null){
            if (list.indexOf(head.val)!=-1){
                if (!seq){
                    seq=true;
                    res++;
                }
            }else {
                seq=false;
            }
            head=head.next;
        }
        return res;
    }
}
