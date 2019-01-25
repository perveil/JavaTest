package lettcode.LinkedList;
public class leetcode86 {
    public static void main(String[] args) {
        new leetcode86().partition(new ListNode(-1).stringToListNode("[1,4,3,2,5,2]"),3);
    }
    public ListNode partition(ListNode head, int x) {
        if (head==null) return null;
        ListNode temp=new ListNode(-1);
        ListNode perv=head;
        ListNode cur=head;
        ListNode next=head;
        while (cur!=null){
            next=cur.next;
            if (cur.val>=x){
                perv.next=cur;
                perv=perv.next;
            }else {
                temp.next=cur;
                temp=temp.next;
                cur.next=null;
            }
            cur=next;
        }
        return temp.next;
    }
}
