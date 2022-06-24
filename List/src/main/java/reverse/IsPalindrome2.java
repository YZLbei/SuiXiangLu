package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/24 11:15
 * @Description:
 */
public class IsPalindrome2 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast =head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast!=null){
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right!=null){
            if (left.val!=right.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;

    }
    
    //将后半部分反转
    public ListNode reverse(ListNode head){
        ListNode pre = null,cur =head;
        while (cur!=null){
            ListNode next =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
