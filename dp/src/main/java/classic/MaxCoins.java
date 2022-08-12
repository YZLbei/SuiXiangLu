package classic;

import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/11 09:04
 * @Description:
 */
public class MaxCoins {
    //气球是否被戳破，true为戳破
    boolean []flag;
    HashMap<LinkedList<Integer>, Integer> map = new HashMap<>();
    public int maxCoins(int[] nums) {
        int n = nums.length;
        flag = new boolean[n];
        LinkedList<Integer> broken = new LinkedList<>();
        return dp(nums,broken);
    }
    //broken表示已经戳破的顺序
    //戳破i的气球最大的金币
    public int dp(int []nums,LinkedList<Integer>broken){
        int n = nums.length;
        System.out.println(broken.size());
        //base case
        if (broken.size()==n){
            return 0;
        }
        if (map.containsKey(broken)){
            return map.get(broken);
        }
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            if (!flag[j]){
                flag[j] = true;
                broken.add(j);
                
                //把j戳破
                //找到j左侧第一个
                int a = j-1;
                int left  = -2;
                while (a>=0){
                    if (!flag[a]){
                        left = nums[a];
                        break;
                    }
                    a--;
                }
                left = left==-2?1:left;
                //找到j右侧第一个
                int b = j+1;
                int right= -2;
                while (b<=n-1){
                    if (!flag[b]){
                        right = nums[b];
                        break;
                    }
                    b++;
                }
                right = right==-2?1:right;
                res =Integer.max(res,dp(nums,broken)+nums[j]*left*right);
                flag[j] = false;
                broken.removeLast();
            }
        }
        map.put(broken,res);
        return res;
    }


    public static void main(String[] args) {
        MaxCoins m = new MaxCoins();
        m.maxCoins(new int[]{3,1,5,8,2,3,3,1,2,78});
    }
    
}
