package subsequence.palindrome;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/31 09:35
 * @Description:让字符串成为回文串的最少插入次数
 */
public class MinInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        if (n==1){
            return 0;
        }
        //dp[i][j]表示[i,j]让字符串成为回文串的最少插入次数
        int [][]dp =new int [n][n];
        for (int i = n-1; i >=0; i--) {
            //注意这里一定是i+1
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Integer.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[0][n-1];
    }
}
