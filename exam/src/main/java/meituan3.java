import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 16:25
 * @Description:
 */
public class meituan3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int [][]board = new int[m][n];
        in.nextLine();
        for (int i = 0;i<m;i++){
            String str = in.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
               int x = in.nextInt();
               int y = in.nextInt();
               int k = in.nextInt();
               a = x;
               b = y;
               int [][] curBoard= new int[m][n];
                for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    curBoard[j][l] = board[j][l];
                    }
                }
            dfs(curBoard, x-1, y-1, k);
            System.out.println(a+" "+b);
        }
        
    }
    static int a;
    static int b;
    static int [][]move = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    static boolean dfs(int [][]board,int i,int j,int k){
        //System.out.println(1);
        if (k==0){
            a = i+1;
            b = j+1;
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        int cur = board[i][j];
        for (int l = 0; l < 4; l++) {
            int x = i+move[l][0];
            int y = j+move[l][1];
            if (x<0||x>=n||y<0||y>=m){
                continue;
            }
            int next = board[x][y];
            if (cur!=next){
                if (cur==1){
                    board[i][j]=0;
                }
                else {
                    board[i][j]=1;
                }
                k--;
                boolean dfs = dfs(board, x, y, k);
                if (dfs){
                    return true;
                }
            }
        }
        a = i+1;
        b = j+1;
        return true;
    }
}
