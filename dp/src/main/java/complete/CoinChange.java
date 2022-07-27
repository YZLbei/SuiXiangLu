package complete;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/27 15:38
 * @Description:
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        long []dp = new long[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                dp[j]  = Long.min(dp[j],dp[j-coins[i]]+1);  
            }
        }
        if (dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        else {
            return (int) dp[amount];
        }
        
    }
}
