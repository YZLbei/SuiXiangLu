package classic;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/13 09:26
 * @Description:更优的思路
 */
public class FourKey2 {
    int maxA(int N){
        int []dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1]+1;
            for (int j = 2; j < i; j++) {
                dp[i] = Integer.max(dp[i],dp[j-2]*(i-j+1));
            }
        }
        return dp[N-1];
    }

    public static void main(String[] args) {
        FourKey2 f = new FourKey2();
        int res = f.maxA(7);
        System.out.println(res);
    }
        
}
