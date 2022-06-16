import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/16 09:37
 * @Description:
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        //��������ڵ�
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        //��������
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
            
            //�Ͽ�ԭ����ÿ���ڵ��nextָ��
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        dummy1.next = dummy2.next;
        return dummy1.next;
    }
}
