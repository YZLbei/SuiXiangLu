import java.util.Arrays;
import java.util.HashMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/22 17:27
 * @Description:
 */
public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0 ;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum+= nums[i];
        }
        int key = 0;
        if (sum%k!=0){
            return false;
        }
        else {
            key = sum/k;
        }
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (nums[i]>key){
                return false;
            }
        }
        System.out.println(key);
        return backtrack(nums,key,k,0,0);
    }

    //true表示用过，false表示没用过
    boolean[]used;
    HashMap<String,Boolean>memo = new HashMap<>();
    public boolean backtrack(int []nums,int key,int k,int num,int sum){
        //找到能划分出的结果
        if(num==k){
            return true;
        }
        String state = Arrays.toString(used);
        //当前桶满了
        if (sum==key){
            boolean res = backtrack(nums, key, k, num + 1, 0);
            memo.put(state,res);
            return res;
        }
        if (memo.containsKey(state)){
            return memo.get(state);
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (used[i]){
                continue;
            }
            boolean res;
            if (sum+nums[i]>key){
                continue;
            }
            else {
                used[i] =true;
                if (sum + nums[i] == key) {
                    res = backtrack(nums, key, k, num, sum + nums[i]);
                } else {
                    res = backtrack(nums, key, k, num, sum + nums[i]);
                }
                used[i] = false;
            }
            if (res){
                return true;
            }
        }
        return false;
    }
    
}

