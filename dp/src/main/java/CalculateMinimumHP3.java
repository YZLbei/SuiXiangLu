import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/5 09:39
 * @Description:递归dp
 */
public class CalculateMinimumHP3 {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        memo = new int[n][m];
        //将备忘录初始都设为-1
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
        return dp(dungeon,0,0);
    }
    int [][]memo;
    //表示的不是从0,0到i,j最小初始血量
    //表示的是i,j到n-1,m-1的最小初始血量
    public int dp(int [][]dungeon,int i,int j){
        int n = dungeon.length;
        int m = dungeon[0].length;
        //base case
        if (i==n-1&&j==m-1){
            return dungeon[i][j]>=0?1:1-dungeon[i][j];
        }
        if (i==n||j==m){
            return Integer.MAX_VALUE;
        }
        if (memo[i][j]!=-1){
            return memo[i][j];
        }
        int res = Integer.min(
                dp(dungeon, i + 1, j),
                dp(dungeon, i, j + 1))-dungeon[i][j];
        memo[i][j] = res<=0?1:res;
        return memo[i][j];
    }
}
