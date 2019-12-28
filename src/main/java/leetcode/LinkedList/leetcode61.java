package leetcode.LinkedList;

public class leetcode61 {
    public static void main(String[] args) {
        new leetcode61().rotateRight(new ListNode(-1).stringToListNode("[1,2,4,5]"),6);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode cur=head;
        int len=0;  //链表的实际长度
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        int p=k%len;
        //求倒数第p+1个节点
        if (p==0) return head;
        ListNode slow=head;
        ListNode quick=slow;
        while(p-->0){
            quick=quick.next;
        }
        while(quick.next!=null){
            slow=slow.next;
            quick=quick.next;
        }
        ListNode headN=slow.next;
        slow.next=null;
        quick.next=head;
        return headN;
    }
}
