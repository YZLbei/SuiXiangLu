package constructor;

import java.util.TreeMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/22 22:13
 * @Description:
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = traverse(preorder, inorder, 0, preorder.length-1, 0, preorder.length-1);
        return root;
    }
    public TreeNode traverse(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
        if (inRight==inLeft){
            return new TreeNode(inorder[inLeft]);
        }
        if (inLeft>inRight){
            return null;
        }
        TreeNode root  = new TreeNode(preorder[preLeft]);
        int rootVal = preorder[preLeft];
        int inroot = inLeft;
        //在中序遍历中找到rootVal
        for (int i = inLeft; i <=inRight; i++) {
            if (rootVal==inorder[i]){
                inroot = i;
                break;
            }
        }
        
        root.left = traverse(preorder,inorder,preLeft+1,inroot-inLeft+preLeft,inLeft,inroot-1);
        root.right = traverse(preorder,inorder, preRight+1-inRight+inroot,preRight,inroot+1,inRight);
        return root;
    }
}
