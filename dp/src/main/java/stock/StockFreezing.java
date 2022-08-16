package stock;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/16 09:06
 * @Description:
 */
public class StockFreezing {
    public int maxProfit(int[] prices) {
        //0表示买入操作
        //1表示买入状态，但不是当天买入
        //2表示卖出操作
        //3表示冷冻期
        //4表示卖出状态，但不是冷冻期
        //冷冻期无法买入股票，持有股票时不能买入
        //卖出操作第二天为冷冻期
        int n = prices.length;
        int[][]dp = new int[n][5];
        dp[0][0] = -prices[0];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.max(dp[i-1][4]-prices[i],dp[i-1][3]-prices[i]);
            dp[i][1] = Integer.max(dp[i-1][1],dp[i-1][0]);
            dp[i][2] = Integer.max(dp[i-1][0]+prices[i],dp[i-1][1]+prices[i]);
            dp[i][3] = dp[i-1][2];
            dp[i][4] = Integer.max(dp[i-1][4],dp[i-1][3]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }
      return   Integer.max(Integer.max(dp[n-1][2],dp[n-1][3]),dp[n-1][4]);
    }
}
