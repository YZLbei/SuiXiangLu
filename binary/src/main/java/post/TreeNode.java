package post;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/21 09:51
 * @Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){
    }
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
