package quick;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/26 19:49
 * @Description:快速选择算法
 */
public class FindKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int low  = 0;
        int high = nums.length-1;
        k = nums.length-k;
        while (low<=high){
            int p = partition(nums, low, high);
            if (p==k){
                return nums[p];
            }
           else if (p<k){
                low = p+1;
            }
           else {
              high =  p-1;
            }
        }
        return -1;
        
    }
    
    public int partition(int []nums,int low ,int high){
        int pivot = nums[low];
        int i = low+1;
        int j = high;
        while (i<=j){
            while (i<high&&nums[i]<=pivot){
                i++;
            }
            while (j>low&&nums[j]>=pivot){
                j--;
            }
            if (i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,low,j);
        return j;
    }
    public void shuffle(int []nums){
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            swap(nums,r,i);
        }
    }
    
    public void swap(int []nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
