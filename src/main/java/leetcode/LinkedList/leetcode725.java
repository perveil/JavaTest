package leetcode.LinkedList;

public class leetcode725 {
    public static void main(String[] args) {
        new leetcode725().splitListToParts(new ListNode(-1).stringToListNode("[]"),11);
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root==null) return null;
        ListNode cur=root;
        int len=0;  //链表的实际长度
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        ListNode[] result=new ListNode[k];

        int p=len%k;  //余数  大于等于0
        int q=len/k;  //商

        ListNode curN=root;
        ListNode next=curN;

        for(int i=0;i<p;i++){
            int j=0;
            while(j++<q){  //取结尾
                next=next.next;
            }
            result[i]=curN;
            ListNode end=next;
            curN=next=next.next;
            end.next=null;
        }
        for(int i=p;i<k;i++){
            int j=0;
            while(j++<q-1){
                next=next.next;
            }
            if (curN==null){
                result[i]=null;
                continue;
            }
            result[i]=curN;
            ListNode end=next;
            curN=next=next.next;
            end.next=null;
        }
        return result;
    }
}
