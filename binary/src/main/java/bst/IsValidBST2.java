package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 12:05
 * @Description:
 */
public class IsValidBST2 {
    long max = Long.MIN_VALUE;
    boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        boolean left = isValidBST(root.left);
        if (root.val>max){
            max = root.val;
        }
        else {
            return false;
        }
        boolean right = isValidBST(root.right);
        return left&&right;
    }
}
