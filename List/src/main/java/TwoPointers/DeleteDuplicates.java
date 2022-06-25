package TwoPointers;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/25 09:51
 * @Description:
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null){
            if (fast.val!=slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
