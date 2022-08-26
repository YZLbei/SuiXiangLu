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
        int target = 0;
        if (sum%k!=0){
            return false;
        }
        else {
            target = sum/k;
        }
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (nums[i]>target){
                return false;
            }
        }
        return backtrack(nums,target,k,0,0);
    }

    //true表示用过，false表示没用过
    boolean[]used;
    HashMap<String,Boolean>memo = new HashMap<>();
    public boolean backtrack(int []nums,int target,int k,int sum,int start){
        //找到能划分出的结果
        if(k==0){
            return true;
        }
        String state = Arrays.toString(used);
        //当前桶满了,递归穷举下一个桶
        if (sum==target){
            boolean res = backtrack(nums, target, k-1, 0, 0);
            memo.put(state,res);
            return res;
        }
        if (memo.containsKey(state)){
            return memo.get(state);
        }
        int n = nums.length;
        for (int i = start; i < n; i++) {
            if (used[i]){
                continue;
            }
            if (sum+nums[i]>target){
                continue;
            }
            else {
                used[i] =true;
                boolean res = backtrack(nums, target, k,sum + nums[i],i+1);
                if (res){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanPartitionKSubsets c = new CanPartitionKSubsets();
        int []num= {18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037};
        boolean b = c.canPartitionKSubsets(num, 4);
        System.out.println(b);
    }
    
}

