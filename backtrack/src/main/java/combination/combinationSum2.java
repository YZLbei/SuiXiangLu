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
        backtrack();
    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    boolean[]used;
    int sum = 0;
    public void backtrack(int k, int n,int startIndex){
        if (path.size()==k&&sum==n){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <=9; i++) {
            if (sum+i>n){
                continue;
            }
            sum+=i;
            path.add(i);
            backtrack(k,n,i+1);
            sum-=i;
            path.removeLast();
        }
    }
}
