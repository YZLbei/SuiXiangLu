import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 11:32
 * @Description:
 */
public class Wind {
    /**
     * res表示最终的结果
     */
    static  int res = Integer.MAX_VALUE;

    /**
     * 问题可以用回溯方法来解决，遍历所有情况，得到最小值
     * @param prices 商品单价
     * @param specials 优惠礼包
     * @param needs 需要的商品
     * @return 最少花费
     */
   static public int minCost(int[]prices,int[][]specials,int[]needs){
        int sum = 0;
        for (int i = 0; i < needs.length; i++) {
            sum+=needs[i];
        }
       backtrack(needs,prices,specials,sum,0);
        return  res;
    }

    /**
     * backtrack函数：买完所有needs中的商品，算出当前的价格并记录，最后得到最小花费
     * @param sum 表示当前还需要购买的商品数量，开始为needs中所有商品数量之和
     * @param curCost 表示当前花费，开始为0
     */
   static public void backtrack(int []needs,int []prices,int [][]specials,int sum,int curCost){
       /**
        * 当sum为0表示已经买完所有商品
        */
        if (sum==0){
            res = Integer.min(res,curCost);
            return;
        }
        int n = prices.length;
        int m = specials.length;
       /**
        * 遍历所有优惠礼包，符合优惠条件就购买
        */
        for (int i = 0; i < m; i++) {
            /**
             * 用来判断是否满足当前优惠条件
             * true表示满足
             * false表示不满足
             */
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                /**
                 * 如果第i个优惠条件中第j个商品比剩余的第j个商品数量多，说明不满足优惠条件
                 */
                if (needs[j]<specials[i][j]){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                continue;
            }
            else {
                /**
                 * 满足优惠条件，就算出买完当前礼包之后的needs数组
                 * 以及当前剩余商品数量
                 */
                for (int j = 0; j < n; j++) {
                    needs[j]-=specials[i][j];
                    sum-=specials[i][j];
                } 
                curCost+=specials[i][n];
                /**
                 * 如果当前花费已经比得到的最小花费更大，就剪枝
                 * 剪枝就是直接进行回退操作
                 */
                if (curCost<res){
                    backtrack(needs,prices,specials,sum,curCost);
                }
                /**
                 * 回退操作
                 * 要把needs数组、商品数量和当前花费回退
                 */
                for (int j = 0; j < n; j++) {
                    needs[j]+=specials[i][j];
                    sum+=specials[i][j];
                }
                curCost-=specials[i][n];
            }
        }
       /**
        * 如果所有优惠都不满足，加上剩余商品的花费
        */
        for (int i = 0; i < needs.length; i++) {
            if (needs[i]!=0){
                curCost+=needs[i]*prices[i];
            }
        }
       /**
        * 已经加上了单独购买商品的花费
        * 此时sum=0，购买完所有商品
        */
       backtrack(needs,prices,specials,0,curCost);
    }

    /**
     * prices  99 24 68
     * specials 1 1 0 110   0 2 1 100
     * needs 3 2 1
     */
    public static void main(String[] args) {
        System.out.println("输入商品个数n:");
        System.out.println("默认为: 3");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []prices = new int[n];
        System.out.println("依次输入商品单价:");
        System.out.println("默认为: 99 24 68");
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        System.out.println("输入优惠礼包个数m:");
        System.out.println("默认为: 2");
        int m = in.nextInt();
        System.out.println("依次输入每个优惠礼包:");
        System.out.println("默认为: 1 1 0 110    0 2 1 100");
        int [][]specials = new int[m][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <=n; j++) {
                specials[i][j] = in.nextInt();
            }
        }
        int []needs = new int[n];
        System.out.println("依次输入需要购买的商品:");
        System.out.println("默认为: 3 2 1");
        for (int i = 0; i < n; i++) {
            needs[i] = in.nextInt();
        }
        int res = minCost(prices, specials, needs);
        System.out.println("最少花费为:"+res);
    }
}
