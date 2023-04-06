package shua;

import reverse.ListNode;

/**
 * @Auther: YuZhenLong
 * @Date: 2023/4/6 15:44
 * @Description:
 */
public class AddTwoNumbers_2 {
    ListNode head;
    ListNode res;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        head = new ListNode(0);
        res = head;
        //true表示进位，false表示不进位
        int flag = 0;
        while (l1!=null||l2!=null){
            if (l1==null){
                flag = add(l2.val+flag);
                l2 = l2.next;
            }
            else if (l2==null){
                flag = add(l1.val+flag);
                l1 = l1.next;
            }
            else {
                flag = add(l1.val+l2.val+flag);
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if (flag==1){
            res.next = new ListNode(flag);
        }
        return head.next;
    }
    
    public int  add(int num){
        int flag = 0;
        if (num <= 9) {
            res.next = new ListNode(num);
            flag = 0;
        }
        else {
            res.next = new ListNode(num%10);
            flag = 1;
        }
        res = res.next;
        return flag;
    }
}
