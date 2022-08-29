package island;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 11:32
 * @Description:
 * 子岛问题：只需要把不是子岛的岛屿淹掉，剩下的都是子岛
 */
public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j]==1&&grid1[i][j]==0){
                    dfs(grid2,i,j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j]==1){
                    res++;
                    dfs(grid2,i,j);
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
