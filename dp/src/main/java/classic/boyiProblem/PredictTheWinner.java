package classic.boyiProblem;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/12 09:36
 * @Description:
 */
public class PredictTheWinner {
    public boolean  PredictTheWinner(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n];
        int [][]sum = new int[n][n];
        for (int i = 0; i < n-1; i++) {
            sum[i][i] = nums[i];
            dp[i][i] = nums[i];
            dp[i][i+1] = Integer.max(nums[i],nums[i+1]);
        }
        
        //求出[i,j]之间的sum
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            for (int j = i+1; j < n; j++) {
                temp+=nums[j];
                sum[i][j] =  temp;
            }
        }
        for (int i = n-3; i >=0; i--) {
            for (int j = i+2; j <n; j++) {
                int temp = sum[i][j] - Integer.min(Integer.max(dp[i + 1][j], dp[i + 1][j]),
                        Integer.max(dp[i][j - 1], dp[i][j - 1]));
//                int temp = Integer.max(sum[i][j]-Integer.max(dp[i + 1][j], dp[i + 1][j]),
//                        sum[i][j]-Integer.max(dp[i][j - 1], dp[i][j - 1]));
                dp[i][j] = Integer.max(dp[i][j],temp);
            }
        }
        int res1 = dp[0][n-1];
        int res2 = sum[0][n-1] - dp[0][n-1];
        if (res1>=res2){
            return true;
        }
        else {
            return false;
        }
    }
    
}
