import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/17 10:04
 * @Description:
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = lists[0];
        for (int i = 1; i < lists.length; i++) {
            dummy.next = mergeTwoLists(dummy.next,lists[i]);
        }
        return dummy.next;
    }
    
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1,p2 = list2;
        while (p1!=null&&p2!=null){
            if (p1.val<p2.val){
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if (p1!=null){
            p.next = p1;
        }
        else if (p2!=null){
            p.next = p2;
        }
        return dummy.next;
    }
}
