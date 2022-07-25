package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 16:15
 * @Description:
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }
        traverse(root,val);
        return root;
    }
    public void traverse(TreeNode root, int val){
        if (root==null){
            return;
        }
        if (root.val>val){
            if (root.left==null){
                root.left = new TreeNode(val);
                return;
            }
            insertIntoBST(root.left,val);
        }
        else {
            if (root.right==null){
                root.right = new TreeNode(val);
                return;
            }
            insertIntoBST(root.right,val);
        }
    }
}
