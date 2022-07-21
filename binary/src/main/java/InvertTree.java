

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/21 15:59
 * @Description:
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode root){
        if (root ==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        traverse(root.left);
        traverse(root.right);
    }
}
