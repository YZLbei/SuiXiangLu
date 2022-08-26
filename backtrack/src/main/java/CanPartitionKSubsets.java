
/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/22 17:27
 * @Description:
 */
public class CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0 ;
        
       int a= 0;
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
        int  remain = n;
        for (int i = 0; i < n; i++) {
            if (nums[i]>key){
                return false;
            }
        }
        System.out.println(key);
        return backtrack(nums,key,k,0,0,remain);
    }

    //true表示用过，false表示没用过
    boolean[]used;
    public boolean backtrack(int []nums,int key,int k,int num,int sum,int remain){
        //找到能划分出的结果
        if(remain==0&&num==k){
            return true;
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
            else if (sum+nums[i]==key){
                used[i] =true;
                res = backtrack(nums, key, k, num+1, 0,remain-1);
                used[i] = false;
            }
            else {
                used[i] = true;
                res = backtrack(nums, key, k, num, sum+nums[i],remain-1);
                used[i] = false;
            }
            if (res){
                return true;
            }
        }
        return false;
    }
    
}

