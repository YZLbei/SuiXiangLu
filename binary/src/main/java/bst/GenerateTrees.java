package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 17:47
 * @Description:
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return build(1,n);
    }
    //构建[low,high]之间的所有二叉树
    public List<TreeNode> build(int low,int high){
        List<TreeNode> res = new LinkedList<>();
        if (low>high){
            res.add(null);
            return res;
        }

        //以i为根节点
        for (int i = low; i <=high; i++) {
            List<TreeNode> left = build(low, i - 1);
            List<TreeNode> right = build(i + 1, high);
            for (TreeNode k : left) {
                for (TreeNode p : right) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = k;
                    tree.right = p;
                    res.add(tree);
                }
            }
        }
        return res;
    }
}
