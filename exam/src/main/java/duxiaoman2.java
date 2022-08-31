import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/31 19:39
 * @Description:
 */
public class duxiaoman2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int [][]nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = in.nextInt();
                }
            }
//            if ((n+m-1)*k<x){
//                System.out.println("no");
//            }
            boolean res = dp(nums, x, 0, 0, 0);
            if (res){
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }
    static boolean dp(int [][]nums,int x,int i,int j,int sum){
        int n = nums.length;
        int m = nums[0].length;
        if (i>=n||j>=m){
            return false;
        }
        sum +=nums[i][j];
        if (i==n-1&&j==m-1){
            if (sum==x){
                return true;
            }
            return false;
        }
        
        //向下
        boolean a = dp(nums, x, i + 1, j, sum);
        if (a){
            return true;
        }
        boolean b = dp(nums, x, i, j + 1, sum);
        if (b){
            return true;
        }
        return false;
    }
}
