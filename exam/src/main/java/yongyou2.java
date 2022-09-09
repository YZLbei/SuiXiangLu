import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/9 19:56
 * @Description:
 */
public class yongyou2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String>sb = new ArrayList<>();
        while (in.hasNext()){
            sb.add(in.nextLine());
        }
        int  n = sb.size();
        List<Integer>[]grid  = new List[n];
        for (int i = 0; i < n; i++) {
            grid[i]  = new LinkedList<>();
            String s = sb.get(i);
            String[] a = s.split(",");
            for (int j = 0; j < a.length; j++) {
                grid[i].add(Integer.parseInt(a[j]));
            }
        }
        int m = grid[0].size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].get(j)==1){
                    res = Integer.max(res,dfs(grid,i,j));
                }
            }
        }
        System.out.println(res);
    }
    
    static int dfs( List<Integer>[]grid,int i ,int j){
        int n = grid.length;
        int m = grid[0].size();
        if (i<0||j<0||i>=n||j>=m){
            return 0;
        }
        if (grid[i].get(j)==0){
            return 0;
        }
        grid[i].set(j,0);
        return dfs(grid,i+1,j)+dfs(grid,i,j+1)+dfs(grid,i-1,j)+dfs(grid,i,j-1)+1;
    }
}
