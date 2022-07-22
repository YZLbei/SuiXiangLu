
import java.util.TreeMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/21 16:31
 * @Description:
 */
public class Flatten {
    public void flatten(TreeNode root) {
        traverse(root);
    }
    public TreeNode traverse(TreeNode root){
        if (root==null) {
            return null;
        }
        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);
        root.left = null;
        TreeNode cur = left;
        if (cur==null){
            root.right = right;
        }
        else {
            while (cur.right != null) {
                cur = cur.right;
            }
            root.right  = left;
            cur.right = right;
        }
        return root;
    }
}
