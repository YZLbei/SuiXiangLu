package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/19 10:25
 * @Description:
 */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = head;
        ListNode temp = head;
        while (p!=null){
             temp = p.next;
             p.next = dummy.next;
             dummy.next = p;
             p = temp;
        }
        return dummy.next;
    }

}
