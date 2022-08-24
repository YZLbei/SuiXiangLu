import java.util.LinkedList;
import java.util.List;

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
        remian = n;
        for (int i = 0; i < n; i++) {
            if (nums[i]>key){
                return false;
            }
        }
        System.out.println(key);
        return backtrack(nums,key,k,0);
    }
    int sum = 0;
    //记录当前划分出子集的个数
    //还没划分集合的个数
    int remian;
    //true表示用过，false表示没用过
    boolean[]used;
    public boolean backtrack(int []nums,int key,int k,int num){
        System.out.println(sum);
        //num也要回溯
        if (num==k&&remian==0){
            return true;
        }
        //return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                int nextNum = num;
                if (sum+nums[i]>key){
                    continue;
                }
                else if (sum+nums[i]==key){
                    nextNum++;
                    sum = 0;
                }
                else {
                    sum += nums[i];
                }                           
                used[i] = true;
                remian--;
                boolean temp = backtrack(nums, key, k,nextNum);
                if (temp){
                    return true;
                }
                sum-=nums[i];
                used[i] = false;
                remian++;
            }
        }
        return false;
    }
    
}

