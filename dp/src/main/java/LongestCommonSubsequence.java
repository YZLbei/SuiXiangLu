/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/30 10:09
 * @Description:
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]表示以[0,i]和[0,j]之间的最长公共子序列
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] =Integer.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        
    }
}
