package rob;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/14 08:27
 * @Description:
 */
public class Rob2 {
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int n = nums.length;
        //不偷第一个
        int []nums1 = new int[n-1];
        //不偷最后一个
        int []nums2 = new int[n-1];
        nums1[0] =  nums[1];
        nums2[0] = nums[0];
        for (int i = 1; i < n-1; i++) {
            nums1[i] = nums[i+1];
            nums2[i] = nums[i];
        }
        int dp1 = dp(nums1);
        int dp2 = dp(nums2);
        return Integer.max(dp1,dp2);
    }

    public int dp(int[] nums) {
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
