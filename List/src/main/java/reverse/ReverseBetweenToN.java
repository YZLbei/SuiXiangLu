package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/19 16:32
 * @Description:
 */
public class ReverseBetweenToN {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }
    public ListNode temp;
    public ListNode reverseN(ListNode head, int n) {
        if (n==1){
            temp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = temp;
        return last;
    }
}
