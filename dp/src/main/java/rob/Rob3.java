package rob;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/14 08:39
 * @Description:
 */


public class Rob3 {

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

    public int rob(TreeNode root) {
      map = new HashMap<>();
      return traverse(root);
      
    }
    Map<TreeNode,Integer>map;
    public int traverse(TreeNode root){
      if (root==null){
          return 0;
      }
      
      else if (root.left==null&&root.right==null){
          return root.val;
      }
      if (map.containsKey(root)){
          return map.get(root);
      }
      //不偷root
      int left1 = 0;
      int right1 = 0;
        if (root.left!=null) {
            left1 = traverse(root.left);
        }
        if (root.right!=null) {
            right1 = traverse(root.right);
        }
        int res1 = left1+right1;
        
        
        //偷root
        int res2 = root.val;
        if (root.left!=null){
            if (root.left.left!=null){
                res2+=traverse(root.left.left);
            }
            if (root.left.right!=null){
                res2+=traverse(root.left.right);
            }
        }
        if (root.right!=null){
            if (root.right.left!=null){
                res2+=traverse(root.right.left);
            }
            if (root.right.right!=null){
                res2+=traverse(root.right.right);
            }
        }
        int res = Integer.max(res1,res2);
        map.put(root,res);
        return res;
    }
}
