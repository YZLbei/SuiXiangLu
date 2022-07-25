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
        if (n==1){
            List<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(1));
            return res;
        }
        //dp[i]表示i个节点的二叉搜索树数量
        List<TreeNode>[]dp =new LinkedList[n+1];
        for (int i = 0; i <=n; i++) {
            dp[i]= new ArrayList<>();
        }
        dp[1].add(new TreeNode(1));
        TreeNode tree1 = new TreeNode(1);
        tree1.right = new TreeNode(2);
        TreeNode tree2 = new TreeNode(2);
        tree2.left = new TreeNode(1);
        dp[2].add(tree2);
        dp[2].add(tree1);
        for (int i = 3; i < n; i++) {
            //表示树以j为根节点的情况
            for (int j = 1; j <=i; j++) {
                TreeNode tree = new TreeNode(j);
                for (int k = 0; k < dp[j - 1].size(); k++) {
                    for (int l = 0; l < dp[i - j].size(); l++) {
                        tree.left = dp[j-1].get(k);
                        tree.right = dp[i-j].get(l);
                        dp[i].add(tree);
                    }
                }
            }
        }
        return dp[n];
    }
}
