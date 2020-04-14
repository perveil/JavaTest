package leetcode.LinkedList;

public class leetcode1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int len=getlen(head);
        if (len==0) return 0;
        int sum=0;
        while (head!=null){
            sum+=head.val*Math.pow(2,--len);
            head=head.next;
        }
        return sum;
    }
    public int getlen(ListNode head) {
        if (head!=null){
            return 1+getlen(head.next);
        }
        return 0;
    }

    public static void main(String[] args) {
        new leetcode1290_二进制链表转整数().getDecimalValue(ListNode.stringToListNode("[1,0,1]"));
    }
}
