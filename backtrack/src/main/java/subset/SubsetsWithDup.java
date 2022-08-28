package subset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/28 16:06
 * @Description:
 * 去重的子集问题
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums,0);
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums,0);
        return res;
    }
    List<List<Integer>>res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    boolean[]used;
    public void backtrack(int []nums,int startIndex){
        res.add(new LinkedList<>(path));
        for (int i = startIndex; i <nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,i+1);
            path.removeLast();
            used[i] = false;
        }
    }
}
