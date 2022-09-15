import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/15 17:43
 * @Description:
 */
public class tp1 {
        static public int lengthOfLIS(int[]nums, int numsSize){
            int []dp = new int[numsSize];
            Arrays.fill(dp,1);
            for(int i=0;i<nums.length;i++){
                for (int j = 0; j < i; j++) {
                    if(nums[i]>nums[j]){
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            int res = 0;
            for(int i=0;i<dp.length;i++){
                res = Math.max(res,dp[i]);
            }
            return res;
        }
        public static void main(String []args){
            int []nums = {3,7,2,1,4,2};
            int i = lengthOfLIS(nums, 6);
            System.out.println(i);
        }
}
