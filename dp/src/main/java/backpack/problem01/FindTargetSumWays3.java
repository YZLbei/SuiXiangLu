package backpack.problem01;

import java.util.HashMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/2 09:20
 * @Description:目标和的回溯写法，加上剪枝
 */
public class FindTargetSumWays3 {
    public int findTargetSumWays(int[] nums, int target) {
      return   dp(nums,0,target);
    }
    HashMap<String,Integer>map = new HashMap<>();
    public int dp(int []nums,int i,int remain){
        //base case
        if (i== nums.length){
            if (remain==0){
                return 1;
            }
            return 0;
        }
        String s = i+","+remain;
        if (map.containsKey(s)){
            return map.get(s);
        }
        int result = dp(nums, i + 1, remain + nums[i]) + dp(nums, i + 1, remain - nums[i]);
        map.put(s,result);
        return result;
    }
}
