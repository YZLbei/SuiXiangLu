package backpack.complete;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/1 09:01
 * @Description:零钱兑换
 * 
 * 相当于完全背包问题
 */
public class Change {
    public int change(int amount, int[] coins) {
        //dp[i]表示有多少种方式凑出i
        int []dp = new int[amount+1];
        
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            //完全背包问题一定是正序的
            for (int j = coins[i]; j <=amount; j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
