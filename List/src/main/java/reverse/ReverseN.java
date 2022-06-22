package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/19 16:08
 * @Description:
 */
public class ReverseN {
    public ListNode reverseN(ListNode head,int n) {
        if (n==1){
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        ListNode temp= head.next.next;
        head.next.next = head;
        head.next = temp;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p =head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        ReverseN r = new ReverseN();
        ListNode last = r.reverseN(head, 3);
         p = last;
         while (p!=null){
             System.out.println(p.val);
             p = p.next;
         }
    }
}
