public class Merge_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-101);
        ListNode p = dummy;
        ListNode p1 = list1,p2 = list2;
        while (p1!=null&&p2!=null){
            System.out.println("p1"+p1.next);
            System.out.println("p2"+p2.next);
            if (p1.val<p2.val){
                p.next = p1;
                p = p.next;
                System.out.println(p.next.val);
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
