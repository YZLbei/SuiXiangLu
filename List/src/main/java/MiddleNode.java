/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/18 10:09
 * @Description:
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
