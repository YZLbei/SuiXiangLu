package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 10:54
 * @Description:
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        return cur&&left&&right;
    }
    
    
    public int traverse(TreeNode root ,int cur){
        if (root==null){
            return 0;
        }
        if (root.val<cur){
            min  = cur;
        }
        
        
    }
}
