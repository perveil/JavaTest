package leetcode.sort.mergesort;/*
  @Date:2020/4/26 9:49
  @Author:Administrator
*/

import leetcode.LinkedList.ListNode;

import java.util.*;

public class leetcode23_合并K个链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0||lists==null) return null;
        return mergeLists(lists,0,lists.length);
    }
    public ListNode mergeLists(ListNode[] lists,int left,int right) {
        if (left==right) return lists[left];
        //切分
        int mid=(left+right)>>1;
        ListNode leftList=mergeLists(lists,left,mid);
        ListNode rightList=mergeLists(lists,mid+1,right);
        //合并
        return mergeTwoLists(rightList,leftList);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(-1);//工作指针
        ListNode resultT=result;
        while(l1!=null&&l2!=null){
            while(l2!=null){
                if(l2.val>=l1.val){
                    result.next=new ListNode(l1.val);//尾插法
                    result=result.next;
                    l1=l1.next;
                    break;
                }else{
                    result.next=new ListNode(l2.val);
                    result=result.next;
                    l2=l2.next;
                    continue;
                }
            }

        }
        if(l1!=null){
            result.next=l1;
        }
        if(l2!=null){
            result.next=l2;
        }
        return resultT.next;
    }
}
