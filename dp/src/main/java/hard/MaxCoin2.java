package hard;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/11 09:04
 * @Description:
 */
public class MaxCoin2 {
    
    HashMap<String, Integer> map = new HashMap<>();
    public int maxCoins(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> last = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            last.add(nums[i]);
        }
        int dp = dp(last);
        System.out.println(dp);
        return dp;
    }
    //last表示剩余气球
    //剩余气球为last最大的金币
    public int dp(LinkedList<Integer>last){
        int n = last.size();
        //base case
        if (n==0){
            return 0;
        }
        if (n==1){
            return last.get(0);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < last.size(); i++) {
            sb.append(last.get(i));
        }
        if (map.containsKey(sb.toString())){
            return map.get(sb.toString());
        }
        int res = Integer.MIN_VALUE;
        
        for (int j = 0; j < n; j++) {
            int left ;
            int right;
            if (j==0) {
                left = 1;
            }
            else {
                left = last.get(j-1);
                //System.out.println(last.get(j-1));
            }
            if (j==n-1) {
                right = 1;
            }
            else {
                right = last.get(j+1);
            }
            int k = last.get(j);
            //j是被戳破的气球
            last.remove(j);
            //System.out.println(left+"   "+k+"    "+right);
            res =Integer.max(res,dp(last)+k*left*right);
            //顺序变了
            last.add(j,k);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < last.size(); i++) {
            sb2.append(last.get(i));
        }
        map.put(sb2.toString(),res);
        return res;
    }


    public static void main(String[] args) {
        MaxCoin2 m = new MaxCoin2();
        m.maxCoins(new int[]{3,1,5,8,23,23,12,12,2});
    }
    
}
