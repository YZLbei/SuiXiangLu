/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/29 19:49
 * @Description:
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            result = Integer.max(sum,result);
            if (sum<0){
                sum = 0;
            }
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        //dp[i][0]表示要dp[i],dp[i][1]表示不要dp[i]
        int []dp =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i-1]+nums[i],nums[i]);
            result = Integer.max(result,dp[i]);
        }
        return result;
    }
}
