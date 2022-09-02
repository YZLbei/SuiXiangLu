import java.util.HashSet;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
 
public class oppo2 {
    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        HashSet<Integer> used1 = new HashSet<>();
        HashSet<Integer> used2 = new HashSet<>();
        int count1= 0 ;
        int count2 = 0;
        int n = 0;
        int m = 0;
        ListNode cur;
        cur = node1;
        while (cur!=null){
            n++;
            cur = cur.next;
        }
        cur = node2;
        while (cur!=null){
            m++;
            cur = cur.next;
        }
        int count = 0;
        ListNode dummycur = dummy;
        while (count1!=n||count2!=m){
            System.out.println(count2);
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minLocation1 = 0;
            int minLocation2 = 0;
            cur = node1;
            count = 0;
            while (cur!=null&&count1!=n){
                if (!used1.contains(count)){
                    if (cur.val<min1){
                        min1 = cur.val;
                        minLocation1 = count;
                    }
                }
                count++;
                cur = cur.next;
            }
            cur = node2;
            count = 0;
            while (cur!=null&&count2!=m){
                if (!used2.contains(count)){
                    if (cur.val<min2){
                        min2 = cur.val;
                        minLocation2 = count;
                    }
                }
                count++;
                cur = cur.next;
            }
            if (min1<min2||count2==m){
                dummycur.next  = new ListNode(min1);
                used1.add(minLocation1);
                count1++;
            }
            else if (count1==n||min1>min2){
                dummycur.next  = new ListNode(min2);
                used2.add(minLocation2);
                count2++;
            }
            else {
//                if (count1!=n){
//                    dummycur.next  = new ListNode(min1);
//                    used1.add(minLocation1);
//                    count1++;
//                }
//                else {
                    dummycur.next  = new ListNode(min2);
                    used2.add(minLocation2);
                    count2++; 
//                }
            }
            dummycur = dummycur.next;
        }   
        return dummy.next;
    }
}
