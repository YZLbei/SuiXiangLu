package backpack.problem01;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/2 09:20
 * @Description:
 */
public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
         int sum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if((sum+target)%2!=0||sum+target<0){
            return 0;
        }
        int res = (sum+target)/2;
        //dp[i]表示全是正数凑出结果i的方法个数
        int []dp = new int[res+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = res; j >=nums[i]; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[res];
    }
}
