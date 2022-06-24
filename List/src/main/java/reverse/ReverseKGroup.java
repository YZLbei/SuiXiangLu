package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/22 10:21
 * @Description:
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = dummy;
        ListNode p2= head;
        int length = 0;
        while (p2!=null){
            length++;
            p2 = p2.next;
        }
        p2 = head;
        ListNode temp;
        ListNode next;
        int k_temp;
        
        while (length>=k){
            length -= k;
            k_temp = k;
            temp = p2;
            while (k_temp>0){
                next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p2 = next;
                k_temp--;
            }
            p1 = temp;
        }
        p1.next = p2;
        return dummy.next; 
    }
    
    
    
    
}
