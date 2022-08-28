package subset;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/28 16:01
 * @Description:相当于求组合问题去掉return
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }
    List<List<Integer>>res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    public void backtrack(int []nums,int startIndex){
        res.add(new LinkedList<>(path));
        for (int i = startIndex; i <nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.removeLast();
        }
    }
    
}
