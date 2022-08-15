package stock;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/15 09:30
 * @Description:
 */
public class Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (prices[i]<min){
                min = prices[i];
            }
            if (prices[i]>min){
                res = Integer.max(res,prices[i]-min);
            }
        }
        return res==Integer.MIN_VALUE?0:res;
    }
}
