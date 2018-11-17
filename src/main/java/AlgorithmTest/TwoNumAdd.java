package AlgorithmTest;
/*
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
* */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class TwoNumAdd {
    public static void main(String[] args) {

    }
    public static ListNode Add(ListNode l1, ListNode l2){
        int Sum=0; //局部值，如果两数相加大于10 就等于1，如果两数相加小于10就为0
        ListNode head1=l1; //第一个链表的头部
        ListNode head2=l2; //第二个链表的头部
        ListNode result=new ListNode(0); //返回的结果
        ListNode resulthead=result;
        while(head1!=null && head2!=null){
            if (head1.val+head2.val+Sum>=10){
                if (Sum==1){
                    result.next=new ListNode((head1.val+head2.val)+Sum-10);
                }else{
                    result.next=new ListNode((head1.val+head2.val)+Sum-10);
                    result.next=new ListNode((head1.val+head2.val)+Sum-10);
                }
                Sum=1;
            }else{
                if (Sum==1){
                    result.next=new ListNode(head1.val+head2.val+Sum);
                }else{
                    result.next=new ListNode(head1.val+head2.val);
                }
                Sum=0;
            }
            head1=head1.next;
            head2=head2.next;
            result=result.next;
        }
        if (head1!=null){
            if(Sum==1){
                head1.val+=1;
                while (head1!=null){
                  if(head1.val>=10){
                      result.next=new ListNode(head1.val-10);
                      result=result.next;
                      if(head1.next!=null){
                          head1.next.val+=1;
                      }else {
                          result.next=new ListNode(1);
                          return resulthead.next;
                      }
                      head1=head1.next;
                  }else{
                      result.next=head1;
                      break;

                  }
                }
                Sum=0;
            }else{
                result.next=head1;
            }

        }
        if(head2!=null){
            if(Sum==1){
                head2.val+=1;
                while (head2!=null){
                    if(head2.val>=10){
                        result.next=new ListNode(head2.val-10);
                        result=result.next;
                        if(head2.next!=null){
                            head2.next.val+=1;
                        }else {
                            result.next=new ListNode(1);
                            return resulthead.next;
                        }
                        head2=head2.next;
                    }else{
                        result.next=head2;
                        break;

                    }
                }
                Sum=0;
            }else{
                result.next=head2;
            }
        }
        if(Sum==1){
            result.next=new ListNode(1);
        }
        return resulthead.next;
    }
}
