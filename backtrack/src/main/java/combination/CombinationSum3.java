package combination;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/26 16:51
 * @Description:
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字最多使用一次 
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1);
        return res;
    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
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
