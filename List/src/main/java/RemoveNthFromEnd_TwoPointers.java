import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/17 16:49
 * @Description:
 */
public class RemoveNthFromEnd_TwoPointers {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = null;
        int count = 0;
        while (p1.next!=null){
            count++;
            p1 = p1.next;
            if (count ==n){
                p2 = head;
                break;
            }
        }
        if (p2==null){
            head = head.next;
            return head;
        }
        while (p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p2.next.next==null){
            p2.next = null;
        }
        else {
            p2.next = p2.next.next;
        }
        
        return head;
    }
}
