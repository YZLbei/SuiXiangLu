package rob;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/14 09:03
 * @Description: 树形dp
 */
public class Rob3II {
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
    public int rob(TreeNode root) {
        int []dp = new int[2];
        dp = traverse(root);
        return Integer.max(dp[0],dp[1]);
    }
    //dp[0]表示不偷，dp[1]表示偷
        public int[] traverse(TreeNode root){
            int []dp = new int[2];
            if (root==null){
                return dp;
            }
            int[] left = traverse(root.left);
            int[] right = traverse(root.right);
            dp[0] = Integer.max(left[0],left[1])+Integer.max(right[0],right[1]);
            dp[1] = left[0]+right[0]+root.val;
            return dp;
        }
    }
}
