package hard;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/11 09:04
 * @Description: dp
 */
public class MaxCoin2 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int []points = new int[n+2];
        points[0] = 1;
        points[n+1] = 1;
        for (int i = 0; i < n; i++) {
            points[i+1] = nums[i];
        }
        //dp[i][j]表示戳破(i,j)的最大金额
        int [][]dp = new int[n+2][n+2];
        for (int i = n+1; i >=0; i--) {
            for (int j = i+1; j <=n+1; j++) {
                for (int k = i+1; k <j; k++) {
                    dp[i][j] = Integer.max(dp[i][j],
                    dp[i][k]+dp[k][j]+points[i]*points[k]*points[j]);
                }   
            }
        }
        return dp[0][n+1];
    }
   
    
}
