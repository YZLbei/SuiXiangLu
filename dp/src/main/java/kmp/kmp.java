package kmp;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/17 11:21
 * @Description:
 */
public class kmp {
    int [][]dp;
    private String pat;
    public kmp(String pat){
        this.pat = pat;
        int M = pat.length();
        //dp[i][c]表示当前当前状态为i，遇到字符c的下一个状态
        dp = new int[M][256];
        int X = 0 ;
        dp[0][pat.charAt(0)] = 1;
        //状态转移图
        for (int i = 1; i < M; i++) {
            for (int c = 0; c < 256; c++) {
                dp[i][c] = dp[X][c];
            }
            dp[i][pat.charAt(i)] = i+1;
            // 更新影子状态
            X = dp[X][pat.charAt(i)];
        }
    }
    public int Search(String txt){
        int N = txt.length();
        int M = pat.length();
        //表示当前状态
        int j = 0;
        for (int i = 0; i < N; i++) {
            j= dp[j][txt.charAt(i)];
            if (j==M){
                return i-M+1;
            }
        }
        return -1;
    }
    
}
