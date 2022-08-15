package stock;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/15 09:45
 * @Description:最多可以完成两笔交易
 */
public class StockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //0表示第一次买入状态
        //1表示第一次卖出状态
        //2表示第二次买入状态
        //3表示第二次卖出状态
        int [][]dp = new int[n][4];
        //base case
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Integer.max(dp[i-1][1],prices[i]+dp[i-1][0]);
            dp[i][2] = Integer.max(dp[i-1][2],dp[i-1][1]-prices[i]);
            dp[i][3] = Integer.max(dp[i-1][3],dp[i-1][2]+prices[i]);
        }
        return dp[n-1][3];
    }
}
