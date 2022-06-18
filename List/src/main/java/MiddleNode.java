/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/18 10:09
 * @Description:
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            if (fast==null){
                break;
            }
        }
        return slow;
    }
}
