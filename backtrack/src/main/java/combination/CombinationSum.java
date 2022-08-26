package combination;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/26 18:50
 * @Description:
 * 无重复的数组求和等于target的所有组合
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,target,0);
        return res;
    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    int sum= 0;
    public void backtracking(int[] candidates, int target,int startIndex){
        if (sum==target){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum+candidates[i]>target){
                continue;
            }
            sum+=candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
