package subsequence.palindrome;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/30 11:13
 * @Description:最长回文子序列
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s.length()==1){
            return 1;
        }
        int n = s.length();
        //dp[i][j]表示[i,j]的最长回文子序列长度
        int [][]dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n; i >=0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else {
                    dp[i][j] = Integer.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
