package leetcode.LinkedList;
/*
  @Date:2020/4/27 16:12
  @Author:Administrator
*/

import java.util.*;

public class leetcode143_重排链表 {
    /*
    * 1->2->3->4->5 断开
    * 1->2->3  4->5  反转4->5
    * 1->2->3   5->4
    * */
    public void reorderList(ListNode head) {
        if (head==null) return;
        ListNode fast=head.next,slow=head;
        //slow 找到中点
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;  //分割
        head2=reverseList(head2); //逆转链表
        ListNode p=head; //工作指针
        while(head2!=null && p!=null){
            //尾插法
            ListNode next=p.next;
            p.next=head2;
            head2=head2.next;
            p.next.next=next;
            p=next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=head.next;
        while(cur!=null){
            cur.next=pre;
            pre=cur;
            if(next==null) break;
            cur=next;
            next=next==null?null:next.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        new leetcode143_重排链表().reorderList(ListNode.stringToListNode("[1]"));
    }
}
