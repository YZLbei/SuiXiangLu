import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2023/4/2 11:19
 * @Description:
 */
public class longestIncreasingPath_329 {
    int [][]dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int [][]dp;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        if(m == 0){
            return 0;
        }
        int res=1;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int num = dfs(matrix,i,j,m,n);
                res = Integer.max(num,res);
                for (int l = 0; l < m; l++) {
                    for (int k = 0; k < n; k++) {
                        System.out.print(dp[l][k]);
                    }
                    System.out.println();
                }
                System.out.println("--------");
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        return res;
    }
    public int dfs(int [][]matrix,int i,int j,int m,int n){
        if (dp[i][j]!=0){
            return dp[i][j];
        }
        for (int k = 0; k < 4; k++){
            int newRow = i + dirs[k][0], newColumn = j + dirs[k][1];
            if(newRow<0 || newRow>=m){
                continue;
            }
            if(newColumn<0 || newColumn>=n){
                continue;
            }
            if(matrix[newRow][newColumn]>matrix[i][j]){
                if (dp[newRow][newColumn]!=0){
                    System.out.println("-----"+i+"------"+j+"------"+newRow+"---"+newColumn+"---"+dp[newRow][newColumn]);
                    dp[i][j] = Integer.max(dp[i][j],1+dp[newRow][newColumn]);
                }
                else {
                    //进行dfs
                    int res = dfs(matrix,newRow,newColumn,m,n);
//                    System.out.println("-----"+i+"------"+j+"------"+res);
                    dp[i][j] = Integer.max(dp[i][j],res+1);
                }
            }
        }
        if (dp[i][j]==0){
            dp[i][j] = 1;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        longestIncreasingPath_329 l = new longestIncreasingPath_329();
        int[][]matrix ={{9,9,4},{6,6,8},{2,1,1}};
        l.longestIncreasingPath(matrix);
    }
}
