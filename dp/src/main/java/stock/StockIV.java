package stock;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/15 10:45
 * @Description: 最多可以交易k次
 */
public class StockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n==0||k==0){
            return 0;
        }
        //[0,2k-1]
        //偶数是买入
        //奇数是卖出
        //dp[2*k]表示第k次买入状态
        //dp[2*k+1]表示第k次卖出状态
        int [][]dp= new int[n][2*k];
        for (int i = 0; i < k; i++) {
            dp[0][2*i] = -prices[0];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <k; j++) {
                int a = 2*j;
                int b = 2*j+1;
                if (a==0){
                    dp[i][a] = Integer.max(dp[i-1][a],prices[i]);
                }
                else {
                    dp[i][a] = Integer.max(dp[i-1][a],dp[i-1][a-1]-prices[i]); 
                }
                dp[i][b] = Integer.max(dp[i-1][b],dp[i-1][b-1]+prices[i]);
            }
        }
        return dp[n-1][2*k-1];
    }
}
