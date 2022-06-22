package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/19 10:55
 * @Description:
 */
public class ReverseListRecursion {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode last =  reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
