package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/24 15:28
 * @Description:
 */
public class ReverseKGroup2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode a,b;
        a = head;
        b = head;
        for (int i = 0; i < k; i++) {
            //����k�������÷�ת��ֱ�ӷ���
            if (b==null){
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        //a.next = next;
        ListNode next = reverseKGroup(b, k);
        a.next = next;
        return newHead;
    }
    public ListNode reverse(ListNode head){
        ListNode pre,cur,next;
        pre = null;
        cur = head;
        while (cur!=null){
            next = cur.next;
            //����ڵ���з�ת
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    //ע��������ҿ�
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre,cur,next;
        pre = null;
        cur = a;
        while (cur!=b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
