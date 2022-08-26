package arrangement;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/20 09:48
 * @Description:全排列
 * 不含重复数字
 */
public class Permute {
    List<List<Integer>>result = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
         backtrack(nums);
         return result;
    }
    public void backtrack(int[] nums){
        int n = nums.length;
        if (path.size()==n){
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backtrack(nums);
                path.removeLast();
            }
        }
    }
    
}
