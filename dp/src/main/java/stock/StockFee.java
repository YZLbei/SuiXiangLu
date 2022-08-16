package stock;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/16 09:50
 * @Description:
 */
public class StockFee {
    public int maxProfit(int[] prices, int fee) {
        //0是买入状态
        //1是卖出状态
        int n = prices.length;
        int[][]dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] =Integer.max(dp[i-1][1],prices[i]+dp[i-1][0]-fee);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i][0]+"   "+dp[i][1]);
        }
        return dp[n-1][1];
    }
}
