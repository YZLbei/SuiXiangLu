package classic;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/13 09:26
 * @Description:
 */
public class FourKey {
    int maxA(int N){
        //第i次操作A的个数
        //0表示A
        //1表示ctrl+A
        //2表示ctrl+C
        //3表示ctrl+V
        int [][]dp = new int[N][4];
        //缓冲区
        //0是复制之后的缓冲区
        //1是粘贴之后的缓冲区
       int  buffer0 = 0;
       int buffer1 = 0;
        //2的前一个操作一定得是1
        //base case
        dp[0][0] = 1;
        for (int i = 1; i < N; i++) {
            int max =Integer.max(Integer.max(dp[i-1][0],dp[i-1][1]),
                    Integer.max(dp[i-1][2],dp[i-1][3]));
            dp[i][0] = max+1;
            dp[i][1] = max;
            int a = buffer0+dp[i-1][2];
            int b = buffer1+dp[i-1][3];
            if (a>=b){
                dp[i][3] = a;
                buffer1 = buffer0;
            }
            else {
                dp[i][3] = b;
            }
            buffer0 = dp[i-1][1];
            dp[i][2] = dp[i-1][1];
        }
        return Integer.max(Integer.max(dp[N-1][0],dp[N-1][1]),
                Integer.max(dp[N-1][2],dp[N-1][3]));
    }

    public static void main(String[] args) {
        FourKey f = new FourKey();
        int res = f.maxA(7);
        System.out.println(res);
    }
        
}
