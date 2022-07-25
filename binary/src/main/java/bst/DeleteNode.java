package bst;

import java.util.TreeMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 16:32
 * @Description:
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        if (root.val==key){
            if (root.right==null){
                return root.left;
            }
            else {
                TreeNode temp = root.right;
                while (temp.left!= null) {
                    temp = temp.left;
                }
                temp.left = root.left;
                return root.right;
            }
        }
        else if (root.val>key) {
            root.left = deleteNode(root.left, key);
        }
        else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    
}
