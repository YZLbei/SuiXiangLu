package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 17:33
 * @Description:
 */
public class NumTrees {
    public int numTrees(int n) {
        if (n==1){
            return 1;
        }
        //dp[i]表示i个节点的二叉搜索树数量
        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n; i++) {
            //表示树以j为根节点的情况
            for (int j = 1; j <=i; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
