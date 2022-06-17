import java.util.List;
import java.util.PriorityQueue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/17 11:13
 * @Description:
 */
public class MergeKLists_Queus {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //优先级队列
        PriorityQueue<ListNode>pq = new PriorityQueue<ListNode>(
                lists.length,
                (a,b)->(a.val - b.val));
        //将k个链表的头节点加入优先级队列
        for (ListNode list : lists) {
            if (list!=null){
                pq.add(list);
            }
        }
        while (!pq.isEmpty()){
            //获取队列中最小节点
            ListNode node = pq.poll();
            p.next = node;
            if (node.next!=null){
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
    
}
