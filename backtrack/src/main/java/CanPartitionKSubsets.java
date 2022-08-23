/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/22 17:27
 * @Description:
 */
public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0 ;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum+= nums[i];
        }
        if (sum%4!=0){
            return false;
        }
        else {
            int key = sum/4;
        }
    }
    public void backtrack(int []nums,int key){
        
    }
}
