package classic;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/10 09:19
 * @Description:
 */
public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        return dp(k,n);
    }
    int [][]memo;
    public int dp(int k,int n){
        //base case
        if(k==1){
            return n;
        }
        if(n==0){
            return 0;
        }
        if (memo[k][n]!=-1){
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        int low =1;
        int high = n;
        while (low<=high){
            int mid = low+(high-low)/2;
            //鸡蛋在mid层碎了和没碎的情况
            int broken = dp(k-1,mid-1);
            int non_broken = dp(k,n-mid);
            if(broken>non_broken){
                //因为broken是单调递增，所以要减小mid
                high = mid-1;
                //broken更大，说明broken是最坏情况
                res =Integer.min(res,broken);
            }
            else {
                low = mid+1;
                res = Integer.min(res,non_broken);
            }
        }
        memo[k][n] =res;
        return memo[k][n];
    }
    
}
