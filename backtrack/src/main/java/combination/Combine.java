package combination;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/28 15:56
 * @Description:
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return res;
    }
    List<List<Integer>>res = new LinkedList<>();
    LinkedList<Integer>path = new LinkedList<>();
    public void backtrack(int n ,int k,int startIndex){
        if (path.size()==k){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <=n; i++) {
            path.add(i);
            backtrack(n,k,i+1);
            path.removeLast();
        }
        
    }
    
}
