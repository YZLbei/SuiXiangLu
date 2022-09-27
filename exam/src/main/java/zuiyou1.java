import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/26 16:43
 * @Description:
 */
class Node {
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class zuiyou1 {
    
    public static void main(String[] args) {
        Node l1 = new Node(9);
        Node cur1 = l1;
        cur1.next = new Node(9);
        cur1 = cur1.next;
        cur1.next = new Node(9);
        cur1 = cur1.next;
        cur1.next = new Node(9);
        Node l2 = new Node(3);
        l2.next = new Node(2);
        //Node res = add(l1, l2);
        Node res = reverse(l2);
        Node cur = res;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    static Node add(Node l1,Node l2){
        Node cur1 = l1;
        Node cur2 = l2;
        Node dummy = new Node(0);
        int carry = 0;
        Node cur = dummy;
        while (cur1!=null||cur2!=null){
            int a = 0;
            int b = 0;
            if (cur1!=null){
                a = cur1.val;
            }
            if (cur2!=null){
                b = cur2.val;
            }
            int c = a+b+carry;
            //System.out.println(c);
            carry = c/10;
            cur.next = new Node(c%10);
            cur = cur.next;
            if (cur1!=null){
                cur1 = cur1.next;
            }
            if (cur2!=null){
                cur2 = cur2.next;
            }
        }
        if (carry>0) {
            cur.next = new Node(carry);
        }
        return dummy.next;
        
    }
   static Node reverse(Node  l1){
        if (l1==null||l1.next==null){
            return l1;
        }
        else {
            Node pre = null;
            Node mid = l1;
            Node end = l1.next;
            while (true){
                mid.next = pre;
                if (end==null){
                    break;
                }
                pre= mid;
                mid = end;
                end = end.next;
            }
            l1 = mid;
            return l1;
        }
    }
}
