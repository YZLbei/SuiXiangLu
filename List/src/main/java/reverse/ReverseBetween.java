package reverse;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/19 15:23
 * @Description:
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null||head.next==null){
            return head;
        }
        else if (left==right){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy,p2 = dummy;
        int p_left = 1,p_right = 1;
        while (p_left!=left){
            p1 = p1.next;
            p2 = p2.next;
            p_left++;
            p_right++;
        }
        while (p_right!=right+1){
            p2 = p2.next;
            p_right++;
        }
        ListNode temp = p2.next;
        p2.next = null;
        ListNode last = reverse(p1.next);
        p1.next.next = temp;
        p1.next = last;
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
