package constructor;

import java.util.TreeMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/22 21:33
 * @Description:构造最大二叉树
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }
    
    public TreeNode traverse(int []nums,int left,int right){
        if (left==right){
            return new TreeNode(nums[left]);
        }
        else if (left>right){
            return null;
        }
        int max = max(nums, left, right);
        TreeNode root = new TreeNode(nums[max]);
        TreeNode treeLeft = traverse(nums, left, max - 1);
        TreeNode treeRight = traverse(nums, max + 1, right);
        root.left  = treeLeft;
        root.right  = treeRight;
        return root;
    }
    
    public int max(int []nums,int left,int right){
        int res = left;
        int max = nums[left];
        for (int i = left+1; i <=right; i++) {
            if (nums[i]>=max){
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
