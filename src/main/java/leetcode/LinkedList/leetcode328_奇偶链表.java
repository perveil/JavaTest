package leetcode.LinkedList;

public class leetcode328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
      if (head==null) return null;
      ListNode head1=new ListNode(-1); //奇数链的头节点
      ListNode res=head1;
      ListNode head2=new ListNode(-1); //偶数链的头节点
      ListNode res2=head2;
      int i=1;
      while (head!=null){
          if (i%2==1){
              head1.next=head;
              head=head.next; //转移状态
              head1=head1.next;
              head1.next=null; //断链
          }else {
              head2.next=head;
              head=head.next; //转移状态
              head2=head2.next;
              head2.next=null; //断链
          }
          i++;
      }
      head1.next=res2.next;
      return res.next;
    }

    public static void main(String[] args) {
        new leetcode328_奇偶链表().oddEvenList(ListNode.stringToListNode("[1,2,3,4,5]"));
    }
}
