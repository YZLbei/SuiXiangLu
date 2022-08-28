package arrangement;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/28 15:49
 * @Description:
 * 数组中包含重复数字的全排列
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        used = new boolean[n];
        //排序后去重
        Arrays.sort(nums);
        backtrack(nums);
        return  res;
    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    boolean[]used;
    public void backtrack(int[] nums){
        int n = nums.length;
        if (path.size()==n){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            //因为是从0开始所以要判断当前数字是否用过
            if (used[i]){
                continue;
            }
            if (i>0&&nums[i]==nums[i-1]&& !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
    
}
