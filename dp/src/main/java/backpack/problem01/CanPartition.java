package backpack.problem01;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/1 08:25
 * @Description:416. 分割等和子集
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }
        if (sum%2!=0){
            return false;
        }
        int res = sum/2;
        //dp[i][j]表示前i个数，最大重量为j，能填入的最大和
        int[][]dp = new int[n][res+1];
        if (nums[0]<res){
            for (int i = nums[0]; i <=res; i++) {
                dp[0][i] = nums[0];
            }
        }
        for (int i = 1; i <n; i++) {
            for (int j = 1; j <=res; j++) {
                if (nums[i]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Integer.max(dp[i-1][j],nums[i]+dp[i-1][j-nums[i]]);
                }
            }
        }
        return dp[n-1][res]==res;
    }
}
