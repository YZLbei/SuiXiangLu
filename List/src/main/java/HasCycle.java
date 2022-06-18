/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/18 10:27
 * @Description:
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow  = slow.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
