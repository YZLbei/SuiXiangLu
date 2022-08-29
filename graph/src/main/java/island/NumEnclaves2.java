package island;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 11:22
 * @Description:只需要把边界的岛屿淹没，查剩余陆地数量
 */
public class NumEnclaves2 {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            //淹没上方岛屿
            if (grid[0][i]==1){
                dfs(grid,0,i);
            }
            //淹没下边岛屿
            if (grid[m-1][i]==1){
                dfs(grid,m-1,i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[i][0]==1){
                dfs(grid,i,0);
            }
            if (grid[i][n-1]==1){
                dfs(grid,i,n-1);
            }
        }
        //淹没之后查陆地数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    res++;
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
        if (grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
