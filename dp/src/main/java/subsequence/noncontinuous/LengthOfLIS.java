package subsequence.noncontinuous;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/27 16:21
 * @Description:
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        //dp[i]表示以i结尾的最长递增子序列
        int []dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i]>result){
                result = dp[i];
            }
        }
        return result;
    }
}
