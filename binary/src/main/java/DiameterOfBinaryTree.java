
/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/21 09:46
 * @Description:相当于求左右两侧最大深度
 */
public class DiameterOfBinaryTree {
    int res;
    public int traverse(TreeNode root) {
        if (root==null){
            return 0;
        }
        int maxLeft = traverse(root.left);
        int maxRight = traverse(root.right);
        if(maxLeft+maxRight>res){
            res = maxLeft+maxRight;
        }
        return Integer.max(maxLeft,maxRight)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }
    
}
