package leetcode.LinkedList;

import java.util.Stack;

public class leetcode86 {
    public static void main(String[] args) {
        new leetcode86().partition(new ListNode(-1).stringToListNode("[1,4,3,2,5,2]"),3);
    }
    // 划分法 划分为比x小的链表和大于等于x的链表
    public ListNode partition(ListNode head, int x) {
        if (head==null) return null;
        ListNode temp=new ListNode(-1);
        temp.next=null;
        ListNode temp1=new ListNode(-1);
        temp1.next=null;
        ListNode pre=temp; //x之前的rear节点
        ListNode next=temp1; //比x大的rear节点
        ListNode cur=head;
        while(cur!=null){
            if (cur.val<x){
                pre.next=cur;
                pre=pre.next;
            }else{
                next.next=cur;
                next=next.next;
            }
            cur=cur.next;
        }
        next.next=null;
        pre.next=null;
        pre.next=temp1.next;
        return temp.next;
    }
}
