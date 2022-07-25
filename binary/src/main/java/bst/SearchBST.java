package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 11:23
 * @Description:
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        else if (root.val>val){
            return searchBST(root.left,val);
        }
        else {
           return searchBST(root.right,val);
        }
    }
}
