/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/19 09:46
 * @Description:
 */
public class GetIntersectionNode {
    //±©Á¦
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        while (p1!=null){
            while (p2!=null){
                if (p2 ==p1){
                    return p2;
                }
                p2 = p2.next;
            }
            p2 = headB;
            p1 = p1.next;
        }
        return null;
            
    }
    
    
    //Ë«Ö¸Õë
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA,p2 = headB;
        int n = 1,m = 1;
        while (p1.next!=null){
            n++;
            p1 = p1.next;
        }
        while (p2.next!=null){
            m++;
            p2 = p2.next;
        }
        if(p1!=p2){
            return  null;
        }
        p1 = headA;
        p2 = headB;
        if(m<n){
            int temp = n-m;
            while (temp>0){
                p1 = p1.next;
                temp--;
            }
        }else if(m>n){
            int temp = m-n;
            while (temp>0){
                p2 = p2.next;
                temp--;
            } 
        }
        while (p1!=null&&p2!=null){
            if (p1==p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}
