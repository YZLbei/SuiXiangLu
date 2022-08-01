package backpack.problem01;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/1 08:25
 * @Description:416. 分割等和子集
 * 
 * 将问题转化为一维
 */

public class CanPartition2 {
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
        //dp[j]表示重量为res最多能填入的重量
        int[]dp = new int[res+1];
        if (nums[0]<=res){
            for (int i = nums[0]; i <=res; i++) {
                dp[i] = nums[0];
            }
        }
        for (int i = 1; i <n; i++) {
            for (int j = res; j >=1; j--) {
                if (nums[i]<j){
                    dp[j] = Integer.max(dp[j],nums[i]+dp[j-nums[i]]);
                }
            }

        }
        return dp[res]==res;
    }
}
