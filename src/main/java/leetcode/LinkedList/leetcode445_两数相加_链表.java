package leetcode.LinkedList;

import java.util.Stack;

public class leetcode445_两数相加_链表 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        return addTwoNumberReverse(l1,l2);
    }
    /*
    * 反转链表
    * */
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
        return cur;
    }
    /*
    * 从链表的头部相加至链表尾部
    * */
    public ListNode addTwoNumberReverse(ListNode l1, ListNode l2) {
        int carry=0;     //默认的进位为0，当最后的进位为1时，就得新增一个节点
        ListNode ans=new ListNode(0);  //头节点
        ListNode cur=ans; //工作节点
        while(l1!=null || l2!=null){ //两个链表可能长短不一
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1 + num2 + carry;
            carry = num / 10; //加和之后计算进位
            cur.next = new ListNode(num % 10); //计算进位之后剩余,尾插法
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        if (carry == 1)    //两个链表一样长可能产生进位
            cur.next = new ListNode(carry);
        return ans.next;
    }
    /*
    * 栈解法，不需要逆转链表
    * */
    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        while(l1!=null){
            stack1.push(l1);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2);
            l2=l2.next;
        }
        int carry=0; //进位
        ListNode res=null; //工作节点
        while (!stack1.isEmpty() ||!stack2.isEmpty()||carry>0){
            int sum=carry+
                    (stack1.isEmpty()?0:stack1.pop().val)
                    +(stack2.isEmpty()?0:stack2.pop().val);
            ListNode newNode=new ListNode(sum%10);
            carry=sum/10;
            newNode.next=res; //头插法
            res=newNode;
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode445_两数相加_链表().addTwoNumbers(
                ListNode.stringToListNode("[7,2,4,3]"),
                ListNode.stringToListNode("[5,6,4]"));
    }
}
