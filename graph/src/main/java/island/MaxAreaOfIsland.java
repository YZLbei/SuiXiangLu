package island;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 11:28
 * @Description:
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    dfs(grid,i,j);
                }
                res = Integer.max(square,res);
                square = 0;
            }
        }
        return res;
    }
    int square = 0;
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
        square++;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
