package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/24 20:48
 * @Description:
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    int count;
    public void traverse(TreeNode root){
        if (root==null){
            return;
        }
        traverse(root.right);
        count+=root.val;
        root.val = count;
        traverse(root.left);
    }
    
    
}
