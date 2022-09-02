/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/2 20:24
 * @Description:
 */
public class oppo {
    public long tourismRoutePlanning (int scenicspot) {
        int []dp = new int[scenicspot+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=scenicspot; i++) {
            if (i+1<=scenicspot){
                dp[i]+=dp[i-1];
            }
            if(i+2<=scenicspot){
                dp[i]+=dp[i-2];
            }
        }
        for (int i = 0; i <=scenicspot; i++) {
            System.out.println(dp[i]);
        }
        return dp[scenicspot];
    }
}
