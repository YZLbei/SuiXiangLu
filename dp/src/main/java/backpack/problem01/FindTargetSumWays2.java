package backpack.problem01;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/2 09:20
 * @Description:目标和的回溯写法
 */
public class FindTargetSumWays2 {
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,target);
        return result;
    }
    int result = 0;
    public void backtrack(int []nums,int i,int remain){
        if (i== nums.length){
            if (remain==0){
                result++;
            }
            return ;
        }
            //nums[i]为+号
            remain-=nums[i];
            backtrack(nums,i+1,remain);
            remain+=nums[i];
            
            
            //nums[j]为-号
            remain+=nums[i];
            backtrack(nums,i+1,remain);
            remain-=nums[i];
    }
}
