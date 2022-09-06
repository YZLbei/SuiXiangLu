import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/6 19:21
 * @Description:
 */
public class manbang2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        Arrays.sort(score);
        dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(dp(0, n, score));
    }
    static int []dp;
    public static int dp(int startIndex,int n,int []score){
        if (startIndex>=n){
            return 0;
        }
        if (dp[startIndex]!=-1){
            return dp[startIndex];
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //used[startIndex] = true;
        int a = dp(startIndex+1,n,score)+1;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        if (startIndex+1<=n-1){
            if(Math.abs(score[startIndex]-score[startIndex+1])<=20){
                b = dp(startIndex+2,n,score)+1;
            }
        }
        if (startIndex+2<=n-1){
            for (int i = 0; i < 3; i++) {
                min = Integer.min(min,score[startIndex+i]);
                max = Integer.max(max,score[startIndex+i]);
            }
            if (max-min<=10){
                c = dp(startIndex+3,n,score)+1;
            }
        }
        int res = Integer.min(a,Integer.min(b,c));
        dp[startIndex] = res;
        return res;
    }
}
