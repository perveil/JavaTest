package leetcode.LinkedList;
/*
*  反转链表的拓展
* */
public class leetcode25 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode  perv=null;
        ListNode  cur=head;
        ListNode  next=head.next;
        while(cur!=null){
            cur.next=perv;
            if(next==null) break;
            perv=cur;
            cur=next;
            next=cur.next;
        }
        return cur; //返回反转后的首节点
    }
    /*
     *  划分法，将整个列表分为已经反转完成的、待反转的、未反转的
     * */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0); //设置头节点
        dummy.next = head;
        /*
        * */
        ListNode pre=dummy; // 待反转链表的前驱
        ListNode end=dummy; //待反转链表的rear
        //end.next==null 遍历完成
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next; //待反转rear
            if (end == null) break;   //未反转小于k 或者 反转结束
            ListNode start=pre.next;
            ListNode next=end.next; //记录未反转的head节点
            end.next=null;
            pre.next=reverseList(start);
            start.next=next;
            pre=start;  //pre 指向反转后的末尾
            end=pre;    //end=pre 恢复初态
        }

        return dummy.next;

    }
    public static void main(String[] args) {

    }
}
