/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/30 10:26
 * @Description:
 */
public class MinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        //dp[i][j]表示以[0,i]和[0,j]之间的最长公共子序列
        int n = s1.length();
        int m = s2.length();
        System.out.println(n);
        System.out.println(m);
        int [][]dp = new int[n+1][m+1];
        int count = 0;
        for (int i = 1; i <=n; i++) {
            count+=Integer.valueOf(s1.charAt(i-1));
            dp[i][0] = count;
        }
        count = 0;
        for (int i = 1; i <=m; i++) {
            count+=Integer.valueOf(s2.charAt(i-1));
            dp[0][m] = count;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] =Integer.min(dp[i-1][j]+Integer.valueOf(s1.charAt(i-1)),
                            dp[i][j-1]+Integer.valueOf(s2.charAt(j-1)));
                }
            }
        }
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }


    public static void main(String[] args) {
        char a = 'a';
        Integer i = Integer.valueOf(a);
        System.out.println(i);
    }
}
