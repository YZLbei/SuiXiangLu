package island;

import java.util.HashSet;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/29 11:50
 * @Description:
 */
public class NumDistinctIslands {
    int numDistinctIslands(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    sb = new StringBuilder();
                    dfs(grid,i,j);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    StringBuilder sb;
    //1,2,3,4分别表示上下左右，5，6，7，8表示上撤销，下撤销，左撤销，右撤销
    public void dfs(int [][]grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        if (i<0||j<0||i>=m||j>=n||grid[i][j]==1){
            sb.append(sb.charAt(sb.length()-1)+4);
            return;
        }
        grid[i][j]=1;
        sb.append(2);
        dfs(grid,i+1,j);
        sb.append(1);
        dfs(grid,i-1,j);
        sb.append(3);
        dfs(grid,i,j-1);
        sb.append(4);
        dfs(grid,i,j+1);
    }

    void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n
                || grid[i][j] == 0) {
            return;
        }
        // 前序遍历位置：进入 (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');

        dfs(grid, i - 1, j, sb, 1); // 上
        dfs(grid, i + 1, j, sb, 2); // 下
        dfs(grid, i, j - 1, sb, 3); // 左
        dfs(grid, i, j + 1, sb, 4); // 右

        // 后序遍历位置：离开 (i, j)
        sb.append(-dir).append(',');
    }
}
