package BFS;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/12 20:51
 * @Description:
 */
public class MinDepth {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
      }
  }
    
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int depth = 1;
        Queue<TreeNode>q = new LinkedList<>();
        //Set<TreeNode> visited = new HashSet<>();
        q.offer(root);
        //visited.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.left==null&&cur.right==null){
                    return depth;
                }
                //visited.add(cur);
                if (cur.left!=null){
                    q.offer(cur.left);
                }
                if (cur.right!=null){
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
