package editDistance;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/30 10:22
 * @Description:删除操作
 */
public class MinDistance2 {
    //把问题转化成求最长公共子序列
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示以[0,i]和[0,j]之间的最长公共子序列
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] =Integer.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return word1.length()+word2.length()-2*dp[n][m];
    }
}
