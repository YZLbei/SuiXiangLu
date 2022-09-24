/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 11:32
 * @Description:
 */
public class Wind {
    //问题可以用动态规划的方法解决，是一道01背包问题
    //needs数组相当于背包
    //prices和specials数组相当于物品
    public int minCost(int[]prices,int[][]specials,int[]needs){
        int n = prices.length;
        int m = specials.length;
        //dp[i]表示背包剩余容量为i，
        int [][]dp = new int[needs.length][needs.length];
        for (int i = 0; i < needs.length; i++) {
            dp[i] = 
        }
    }
}
