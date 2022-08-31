import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/31 20:02
 * @Description:
 */
public class duxiaoman3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long []dp = new long[n+1];
//        dp[0] = 0;
//        dp[1] = 0;
//        dp[2] = ;
//        dp[3] = 25;
        dp[0] = 1;
        dp[1] = 9;
        dp[2] = 80;
        dp[3] = 704;
        for (int i = 4; i <=n; i++) {
            dp[i] = dp[i-1]*8+dp[i-3]*64;
        }
        System.out.println(dp[n]%1000000007);
    }
}
