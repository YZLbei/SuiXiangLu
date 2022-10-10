import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/10/10 20:22
 * @Description:
 */
public class fanshimianshi {
    public static void main(String[] args) {
        int [][]matrix = new int[][]{{1,0,1,2},{1,0,1,1},{1,1,1,1},{1,0,1,2}};
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]==2){
                    count++;
                    q1.offer(i);
                    q2.offer(j);
                }
                if (matrix[i][j]==0){
                    sum++;
                }
            }
        }
        int res = bfs(matrix);
        System.out.println(res);
        System.out.println(count);
    }
    static Queue<Integer>q1  = new LinkedList<>();
    static Queue<Integer>q2  = new LinkedList<>();
    //static Set<Integer> set = new HashSet<>();
    static int count = 0;
    static int sum = 0;
    static  int bfs(int [][]matrix){
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        while (!q1.isEmpty()){
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                int x = q1.poll();
                int y = q2.poll();
                judge(matrix,x+1,y);
                judge(matrix,x-1,y);
                judge(matrix,x,y-1);
                judge(matrix,x,y+1);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            res++;
            if (count==n*m-sum){
                break;
            }
        }
        if (count!=n*m-sum){
            return -1;
        }
        else {
            return res;
        }
    }
    static void judge(int [][]matrix,int x,int y){
        int n = matrix.length;
        int m = matrix[0].length;
        if (x<0||x>=n||y<0||y>=m){
            return;
        }
        else if (matrix[x][y]==0||matrix[x][y]==2){
            return;
        }
        else if (matrix[x][y]==1){
            matrix[x][y]=2;
            q1.offer(x);
            q2.offer(y);
            count++;
        }
        
    }
}
