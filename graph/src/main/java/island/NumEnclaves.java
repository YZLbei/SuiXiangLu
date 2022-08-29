package island;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 09:36
 * @Description:
 */
public class NumEnclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0){
                    continue;
                }
                else if (grid[i][j]==1){
                    if (!dfs(grid,i,j)){
                        res++;
                    }
                }

            }
        }
        return res;
    }
    //visited为false表示没访问过，true表示访问过
    boolean [][]visited;
    public boolean dfs(int[][] grid,int i ,int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i==0||j==0||i==m-1||j==n-1){
            return true;
        }
        visited[i][j] =true;
        //选择
        if (i>0&&grid[i-1][j]==1&&!visited[i-1][j]){
            boolean a = dfs(grid, i - 1, j);
            if (a){
                visited[i][j] = false;
                return true;
            }
        }
        if (j>0&&grid[i][j-1]==1&&!visited[i][j-1]){
            boolean b = dfs(grid, i, j-1);
            if (b){
                visited[i][j] = false;
                return true;
            }
        }
        if (j<n-1&&grid[i][j+1]==1&&!visited[i][j+1]){
            boolean c = dfs(grid, i, j+1);
            if (c){
                visited[i][j] = false;
                return true;
            }
        }
        if (i<m-1&&grid[i+1][j]==1&&!visited[i+1][j]){
            boolean d = dfs(grid, i+1, j);
            if (d){
                visited[i][j] = false;
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
