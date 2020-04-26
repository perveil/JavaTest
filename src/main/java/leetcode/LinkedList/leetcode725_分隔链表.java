package leetcode.LinkedList;

public class leetcode725_分隔链表 {
    public static void main(String[] args) {
        new leetcode725_分隔链表().splitListToParts(new ListNode(-1).stringToListNode("[]"),11);
    }
    /*
    * params：
    *       root：目标链表
    *       k:链表分成k份
    *
    * */
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root==null) return null;
        ListNode cur=root;
        int len=0;  //链表的实际长度
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        ListNode[] result=new ListNode[k];
        //  l=n*(i+1)+m*(i)   n+m=k
        int p=len%k;  //余数    n
        int q=len/k;  //商      i

        ListNode curN=root; //工作指针
        ListNode next=curN;

        for(int i=0;i<p;i++){
            int j=0;
            while(j++<q){  //取结尾 长度为q+1
                 next=next.next;
            }
            result[i]=curN;
            ListNode end=next;
            curN=next=next.next;
            end.next=null;
        }
        for(int i=p;i<k;i++){
            int j=0;
            while(j++<q-1){ //取结尾，长度为 q
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
