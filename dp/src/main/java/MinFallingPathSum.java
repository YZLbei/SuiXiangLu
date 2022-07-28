/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/28 11:40
 * @Description:
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n  = matrix.length;
        //表示dp[i][j]结尾的下降路径最小和
        int [][]dp = new int[n][n];
        
        for (int i = 0; i < n ; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0){
                    dp[i][j] = matrix[i][j]+Integer.min(dp[i-1][j],dp[i-1][j+1]);
                }
                else if (j==n-1){
                    dp[i][j] = matrix[i][j]+Integer.min(dp[i-1][j],dp[i-1][j-1]);
                }
                else {
                    dp[i][j] = matrix[i][j] + Integer.min(dp[i - 1][j + 1], Integer.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Integer.min(dp[n-1][i],res);
        }
        return res;
    }
}
