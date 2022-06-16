import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/16 09:37
 * @Description:
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        //两个虚拟节点
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        //遍历两次
        while (p!=null){
            if (p.val<x){
                p1.next = p;
                p1 = p1.next;
            }
            else{
                p2.next = p;
                p2 = p2.next;
            }
            //p = p.next;
            
            //断开原链表每个节点的next指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        dummy1.next = dummy2.next;
        return dummy1.next;
    }
}
