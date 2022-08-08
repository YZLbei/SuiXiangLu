import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/8 10:29
 * @Description:动态规划
 */
public class FindCheapestPrice2 {
    //哈希表记录入度
    // to -> [from, price]
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        indegree = new HashMap<>();
        memo = new int[n][k+1];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        this.src =src;
        this.dst =dst;
        for (int i = 0; i < n; i++) {
            indegree.putIfAbsent(i,new LinkedList<>()); 
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            //判断键值是否存在，不存在则插入
            //indegree.putIfAbsent(to,new LinkedList<>());
            indegree.get(to).add(new int[]{from,price});
        }
        return dp(dst, k);
    }
    int [][]memo;
    //从src到i，k步之内的最小的距离
    public int dp(int i,int k){
        //base case
        if (i==src) {
            return 0;
        }
        //步数耗尽
        if (k==-1){
            return -1;
        }
        if(memo[i][k]!=-1){
            return memo[i][k];
        }
        
        List<int[]> ints = indegree.get(i);
        if (ints.isEmpty()){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < ints.size(); j++) {
            int from = ints.get(j)[0];
            int price = ints.get(j)[1];
            int dp = dp(from, k - 1);
            if (dp==-1){
                continue;
            }
            //System.out.println(dp(from,k-1)+price);
            res = Integer.min(res,dp+price);
        }
        res =res==Integer.MAX_VALUE?-1:res;
        memo[i][k] =res;
        return res;
    }
}
