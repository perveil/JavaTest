package leetcode.LinkedList;

import java.util.Stack;

/*
*  链表排序 ->选择排序/归并排序
* */
public class leetcode147Or148 {
    /*
      选择排序,双栈 退栈进栈解决-->超出内存限制
     */
    public ListNode insertionSortList(ListNode head) {
        if (head==null) return null;
        Stack<ListNode> input=new Stack<>();
        Stack<ListNode> input1=new Stack<>(); // 中转栈
        input.push(head);     //初始化栈，第一个节点入栈
        ListNode temp=head.next;
        while(temp!=null){
            int num=temp.val;
            while(!input.isEmpty()){
                ListNode temp2=input.peek(); //选栈顶元素
                if (temp2.val<num){
                    input1.push(input.pop());
                }else{
                    break;
                }
            }
            input.push(temp);
            while(!input1.isEmpty()){
                input.push(input1.pop()); //input1 栈中元素退回input
            }
            temp=temp.next;
        }
        ListNode result=input.pop();
        ListNode  rear=result;
        while(!input.isEmpty()){
            ListNode temp1=input.pop();
            rear.next=temp1;
            rear=rear.next;
        }
        return result;
    }
    /*
       不使用辅助空间，在原链表的基础上排序
       链表分为未排序的与排序成功的两个链表
     */
    public ListNode Modify_insertionSortList(ListNode head) {
        if(null == head) return null;
        ListNode complete = head;  //complete 已经完成的链表的头节点
        ListNode execute  = head.next;  //待排序的链表
        complete.next=null;
        if(null == execute) return complete;
        do{
            ListNode node=execute;
            execute=execute.next;
            ListNode prev=null;  //遍历complete 链表的之前的指针
            ListNode next=complete;
            while (next!=null&&next.val<node.val){
                prev=next;
                next=next.next;
            }
            if (prev!=null) {   //complete节点的前边是null
                prev.next=node;
            }else
                complete=node;
            node.next=next;  //连接断开的complete链表
        }while (execute!=null);
        return complete;
    }
    /*
    *  归并排序 二分法Cut链表,向上Merge
    * Cut链表: 快慢指针找中点，然后从中点断开
    * Merge:两个有序链表的合并，使用头插法从小到大排列
    * */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  //空或长度为一,划分结束
            return head;
        /*
        * 快慢指针找中点,最终slow 指向中点
        * */
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        /*
        * 递归划分
        * */
        ListNode left=sortList(head);
        ListNode right=sortList(head2);
        /*
        * 合并两个有序链表
        * */
        ListNode h = new ListNode(0);
        ListNode res = h;
        /*
        * 头插法插入
        * */
        while(left!=null&&right!=null){
            if (left.val<right.val){
                h.next=left;
                left=left.next;
            }else {
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        if (left!=null) h.next=left;
        if (right!=null) h.next=right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode input=new ListNode(1).stringToListNode("[5,5,4,3,8]");
        new leetcode147Or148().insertionSortList(input);
    }
}
