import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 17:04
 * @Description:
 */
public class meituan4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        int [][]dp= new int[n][2];
        int [][]count = new int[n][2];
        //0--use
        dp[0][1] = 0;
        if (num[0]==0){
            dp[0][0]=1;
        }
        else {
            count[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (dp[i-1][0]>dp[i-1][1]){
                dp[i][1] = dp[i-1][0];
                count[i][1] = count[i-1][0];
            }
            else if (dp[i-1][0]==dp[i-1][1]){
                dp[i][1] = dp[i-1][0];
                count[i][1] = Integer.max(count[i-1][0],count[i-1][0]);
            }
            else {
                dp[i][1] = dp[i-1][1];
                count[i][1] = count[i-1][1];
            }
            if (num[i]==0){
                int a = dp[i - 1][0] + count[i - 1][0]+1;
                int b = dp[i - 1][1] + count[i - 1][1]+1;
                if (a>b){
                    count[i][0] = count[i-1][0];
                }
                else if (a==b){
                    count[i][0] = Integer.max(count[i-1][0],count[i-1][1]);
                }
                else {
                    count[i][0] = count[i-1][1];
                }
                dp[i][0]=Integer.max(a,b);
            }
            else {
                int a = dp[i - 1][0] / 2;
                int b = dp[i - 1][1] / 2;
                dp[i][0]=Integer.max(a,b);
                if (a>b){
                    count[i][0] = count[i-1][0]+1;
                }
                else if (a==b){
                    count[i][0] = Integer.max(count[i-1][0],count[i-1][1])+1;
                }
                else {
                    count[i][0] = count[i-1][1]+1;
                }
            }
        }
        System.out.println(Integer.max(dp[n-1][0],dp[n-1][1]));
    }
}
