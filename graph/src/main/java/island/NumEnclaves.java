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
        visited = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==0||(grid[i][j]==1&&visited[i][j]==1)){
                    continue;
                }
                else if (grid[i][j]==1&&grid[i][j]==0){
                    if (!dfs(grid,i,j)){
                        res++;
                    }
                }
                else if (grid[i][j]==1&&grid[i][j]==2){
                    res++;
                }
            }
        }
        return res;
    }
    //visited为0表示没访问过，1表示访问过可以到达边界，2表示访问过不可以到达边界,3表示访问过不知道是否能到达边界
    int [][]visited;
    public boolean dfs(int[][] grid,int i ,int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i==0||j==0||i==m-1||j==n-1){
            return true;
        }
        if (visited[i][j]==1){
            return true;
        }
        else if(visited[i][j]==2){
            
        }
        visited[i][j] =3;
        //选择
        if (i>0&&grid[i-1][j]==1){
            if (visited[i][j]==1){
                return true;
            }
            else if(visited[i][j]==2){
                
            }
            else if (){
                
            }
            boolean a = dfs(grid, i - 1, j);
            if (a){
                visited[i][j] = 1;
                return true;
            }
        }
        if (j>0&&grid[i][j-1]==1&&!visited[i][j-1]){
            boolean b = dfs(grid, i, j-1);
            if (b){
                visited[i][j] = 1;
                return true;
            }
        }
        if (j<n-1&&grid[i][j+1]==1&&!visited[i][j+1]){
            boolean c = dfs(grid, i, j+1);
            if (c){
                visited[i][j] = 1;
                return true;
            }
        }
        if (i<m-1&&grid[i+1][j]==1&&!visited[i+1][j]){
            boolean d = dfs(grid, i+1, j);
            if (d){
                visited[i][j] = 1;
                return true;
            }
        }
        visited[i][j] = 2;
        return false;
    }









//    public int numEnclaves(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        visited = new boolean[m][n];
//        int res = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j]==0){
//                    continue;
//                }
//                else if (grid[i][j]==1){
//                    if (!dfs(grid,i,j)){
//                        res++;
//                    }
//                }
//
//            }
//        }
//        return res;
//    }
//    //visited为false表示没访问过，true表示访问过
//    boolean [][]visited;
//    public boolean dfs(int[][] grid,int i ,int j){
//        int m = grid.length;
//        int n = grid[0].length;
//        if(i==0||j==0||i==m-1||j==n-1){
//            return true;
//        }
//        visited[i][j] =true;
//        //选择
//        if (i>0&&grid[i-1][j]==1&&!visited[i-1][j]){
//            boolean a = dfs(grid, i - 1, j);
//            if (a){
//                visited[i][j] = false;
//                return true;
//            }
//        }
//        if (j>0&&grid[i][j-1]==1&&!visited[i][j-1]){
//            boolean b = dfs(grid, i, j-1);
//            if (b){
//                visited[i][j] = false;
//                return true;
//            }
//        }
//        if (j<n-1&&grid[i][j+1]==1&&!visited[i][j+1]){
//            boolean c = dfs(grid, i, j+1);
//            if (c){
//                visited[i][j] = false;
//                return true;
//            }
//        }
//        if (i<m-1&&grid[i+1][j]==1&&!visited[i+1][j]){
//            boolean d = dfs(grid, i+1, j);
//            if (d){
//                visited[i][j] = false;
//                return true;
//            }
//        }
//        visited[i][j] = false;
//        return false;
//    }
}
