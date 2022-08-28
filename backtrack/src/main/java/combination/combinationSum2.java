package combination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/26 18:57
 * @Description:
 * 给定的数组中存在重复，每个数字只能用一次
 * 用used去重
 */
public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        used = new boolean[n];
        //排序后去重
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return  res;
    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    boolean[]used;
    int sum = 0;
    public void backtrack(int[] candidates, int target,int startIndex){
        if (sum==target){
            res.add(new LinkedList<>(path));
            return;
        }
        int n = candidates.length;
        for (int i = startIndex; i < n; i++) {
            if (sum+candidates[i]>target){
                continue;
            }
            if (i>0&&candidates[i]==candidates[i-1]&& !used[i - 1]){
                continue;
            }
            sum+=candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtrack(candidates,target,i+1);
            sum-=candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }
}
