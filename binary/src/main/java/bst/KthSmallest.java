package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/24 18:40
 * @Description:
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        traverse(root);
        return res;
    }
    int num;
    int res;
    public void traverse(TreeNode root){
        System.out.println(num);
        if (root==null){
            return;
        }
        traverse(root.left);
        num--;
        if (num==0){
            res = root.val;
            return;
        }
        traverse(root.right);
    }
    
}
