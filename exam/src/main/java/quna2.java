/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/21 20:13
 * @Description:
 */
public class quna2 {
    public int handle (int[][] matrix) {
        // write code here
        int n = matrix.length;
        if (n==1){
            return 0;
        }
        if (n==2){
            int res = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                res = Integer.min(res,matrix[0][i]);
            }
            return res;
        }
        used = new boolean[n];
        used[0] = true;
        dfs(matrix,0,0);
        return res;
    }
    int res = Integer.MAX_VALUE;
    boolean[]used;
    public void dfs(int[][] matrix,int i,int path){
        int n = matrix.length;
        if (i==n-1){
           res  = Integer.min(res,path);
           System.out.println(path);
           return ;
        }
        for (int j = 0; j < n; j++) {
            if (i!=j&&matrix[i][j]!=-1&&!used[j]&&matrix[i][j]!=0){
                if (path+matrix[i][j]>res){
                    continue;
                }
                path+=matrix[i][j];
                used[j] = true;
                dfs(matrix, j, path);
                path-=matrix[i][j];
                used[j] = false;
            }
        }
    }
}
