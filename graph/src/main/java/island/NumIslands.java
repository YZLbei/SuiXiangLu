package island;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 10:43
 * @Description:岛屿数量
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n  =grid[0].length;
        int res= 0 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i, int j){
        int m = grid.length;
        int n  =grid[0].length;
        //上下左右
        int[][]dis ={{-1,0},{1,0},{0,-1},{0,1}};
        if (i<0||j<0||i>=m||j>=n){
            return;
        }
        if (grid[i][j]=='0'){
            return;
        }
        //将岛屿淹没
        grid[i][j]='0';
        for (int[] di : dis) {
            dfs(grid,i+di[0],j+di[1]);
        }
    }
    
}
