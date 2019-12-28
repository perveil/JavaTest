package leetcode.LinkedList;


public class leetcode82 {
    public static void main(String[] args) {
        new leetcode82().deleteDuplicates(new ListNode(-1).stringToListNode("[1,2,3,3,4,4,5]"));
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        if (head.next==null) return head;
        ListNode tempNode=new ListNode(-1);
        ListNode result=tempNode;
        int aims=1; //命中数
        int temp=head.val;  //记录值
        ListNode cur=head;
        cur=cur.next;
        while(cur!=null){
            if (cur.val==temp){
                aims++;
            }else{
                if (aims==1){
                    tempNode.next=new ListNode(temp);
                    tempNode=tempNode.next;
                }
                temp=cur.val;
                aims=1;
            }
            if (cur.next==null&&aims==1){
                 tempNode.next=new ListNode(temp);
            }
            cur=cur.next;
        }
        return result.next;
    }
}
