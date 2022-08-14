package rob;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/14 08:20
 * @Description:
 */
public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        //0表示不偷，1表示偷
        int [][]dp = new int[n][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0]+nums[i];
        }
        return Integer.max(dp[n-1][0],dp[n-1][1]);
    }
    
}
