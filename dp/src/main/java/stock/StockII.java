package stock;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/15 09:40
 * @Description:
 */
public class StockII {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<min){
                min = prices[i];
            }
            else if (prices[i]>min){
                res+=prices[i]-min;
                min = prices[i];
            }
        }
        return res;
    }
}
