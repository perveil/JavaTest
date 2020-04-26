package leetcode.sort.mergesort;
/*
  @Date:2020/4/26 10:19
  @Author:Administrator
*/

import leetcode.LinkedList.ListNode;

import java.util.*;

public class leetcode149_排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) //空或长度为一,切分结束
            return head;
        ListNode fast = head.next, slow = head;
        //最终slow 指向中点左侧
        //当链表长度为奇数时，slow中点，链表为偶数时，slow为左侧
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        //切分
        ListNode  left=sortList(head);
        ListNode  right=sortList(head2);
        //合并 尾插法
        ListNode h = new ListNode(0); //头节点
        ListNode res = h;
        while(left!=null&&right!=null){
            if (left.val<right.val){
                h.next=left;
                left=left.next;
            }else {
                h.next=right;
                right=right.next;
            }
            h=h.next;//向下移动
        }
        if (left!=null) h.next=left;
        if (right!=null) h.next=right;
        return res.next;
    }
}
