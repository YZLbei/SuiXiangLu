package island;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 10:56
 * @Description:
 */
public class ClosedIsland {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            //淹没上方岛屿
            if (grid[0][i]==0){
                dfs(grid,0,i);
            }
            //淹没下边岛屿
            if (grid[m-1][i]==0){
                dfs(grid,m-1,i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0]==0){
                dfs(grid,i,0);
            }
            if (grid[i][n-1]==0){
                dfs(grid,i,n-1);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(int [][]grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0||j<0||i>=m||j>=n){
            return;
        }
        if (grid[i][j]==1){
            return;
        }
        grid[i][j]=1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
