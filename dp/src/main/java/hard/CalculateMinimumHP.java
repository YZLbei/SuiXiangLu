package hard;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/3 21:59
 * @Description:
 * 
 * 难点
 * 
 * 注意起始需要一点血，最开始不能为0血
 */
public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        //dp[i][j][0]表示到达i,j需要的最小初始血量
        //dp[i][j][1]表示到达i,j当前的血量
        //如果走到i，j血量为负值说明初始血量需要增加，当前血量为0
        int [][][]dp = new int [n][m][2];
        if (dungeon[0][0]<=0){
            dp[0][0][0] = -dungeon[0][0]+1;
            dp[0][0][1] = 1;
        }
        else {
            dp[0][0][1] = dungeon[0][0]+1;
            dp[0][0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = dp[i-1][0][1]+dungeon[i][0];
            if (dp[i][0][1]<=0){
                dp[i][0][0] = dp[i-1][0][0]-dp[i][0][1]+1;
                dp[i][0][1]=1;
            }
            else {
                dp[i][0][0] = dp[i-1][0][0];
            }
        }
        for (int i = 1; i < m; i++) {
            dp[0][i][1] = dp[0][i-1][1]+dungeon[0][i];
            if (dp[0][i][1]<=0){
                dp[0][i][0] = -dp[0][i][1]+dp[0][i-1][0]+1;
                dp[0][i][1] = 1;
            }
            else {
                dp[0][i][0] =dp[0][i-1][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                //如果最小值是左侧节点的当前血量
                int left_cur = dp[i][j-1][1]+dungeon[i][j];
                //如果最小值是左侧节点的最小初始血量
                int left_min;
                if (left_cur<=0){ 
                    left_min = dp[i][j-1][0]-left_cur+1;
                    left_cur = 1;
                }
                else {
                    left_min = dp[i][j-1][0];
                }
                
                int up_cur = dp[i-1][j][1]+dungeon[i][j];
                int up_min;
                if (up_cur<=0){
                    up_min = dp[i-1][j][0]-up_cur+1;
                    up_cur = 1;
                }
                else {
                    up_min = dp[i-1][j][0];
                }
                if (left_min>up_min){
                    dp[i][j][0] = up_min;
                    dp[i][j][1] = up_cur;
                }
                else if (left_min<up_min){
                    dp[i][j][0] = left_min;
                    dp[i][j][1] = left_cur;
                }
                else {
                    if (up_cur>=left_cur){
                        dp[i][j][0] = up_min;
                        dp[i][j][1] = up_cur;
                    }
                    else {
                        dp[i][j][0] = left_min;
                        dp[i][j][1] = left_cur;
                    }
                }
                
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(dp[i][j][0]+"  "+dp[i][j][1]);
            }
        }
        return dp[n-1][m-1][0];
    }
    
}
