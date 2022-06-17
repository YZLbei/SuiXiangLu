import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/17 11:49
 * @Description:
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode p = head;
        while (p!=null){
            p = p.next;
            length++;
        }
        if (length==1){
            return null;
        }
        p =head;
        //System.out.println(length);
        if (n ==1){
            while (p!=null){
                if (p.next.next==null){
                    p.next = null;
                }
                 p = p.next;
            }
        }
        else if (n==length){
            head = head.next;
        }
        else {
            int location = length - n - 1;
            int count = 0;
            while (p != null) {
                if (count == location) {
                    p.next = p.next.next;
                    break;

                }
                p = p.next;
                count++;
            }
        }
        return head;
    }
}
