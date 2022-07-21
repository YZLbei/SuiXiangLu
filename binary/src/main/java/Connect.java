
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/21 16:16
 * @Description:层次遍历
 */
public class Connect {
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        Queue<Node>q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            Node last;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i!=size-1){
                    cur.next = q.peek();
                }
                else {
                    cur.next = null;
                }
                if (cur.left!=null) {
                    q.offer(cur.left);
                }
                if (cur.right!=null) {
                    q.offer(cur.right);
                }
            }
        }
        return root;
    }
}
