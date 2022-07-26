package quick;

import java.util.Random;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/26 18:02
 * @Description:
 */
public class Quick {
    public void sort(int []nums){
        shuffle(nums);
        sort(nums,0,nums.length-1);
    }

    public void sort(int []nums,int low ,int high){
        if (low>=high){
            return;
        }
        // 使得 nums[lo..p-1] <= nums[p] <=nums[p+1..hi]
        int p = partition(nums, low, high);
        sort(nums,low,p-1);
        sort(nums,p+1,high);
    }
    public int  partition(int []nums,int low ,int high){
        int pivot = nums[low];
        // [lo, i] <= pivot；[j, hi] >=pivot
        int i = low+1;
        int j = high;

        while (i<=j){
            //循环结束时nums[i]>pivot
            while (i<high&&nums[i]<=pivot){
                i++;
            }
            //循环结束时nums[j]<pivot
            while (j>low&&nums[j]>=pivot){
                j--;
            }
            if (i>=j){
                break;
            }
            swap(nums,i,j);
        }
        //因为nums[j]<pivot ,所以交换low和j
        swap(nums,low,j);
        return j;
    }


    //洗牌算法
    public void shuffle(int []nums){
        Random random = new Random();
        int n  = nums.length;
        for (int i = 0; i < n; i++) {
            //生成[i,n-1]之前的随机数
            int r = i+random.nextInt(n - i);
            swap(nums,i,r);
        }
    }

    public void swap(int []nums,int a ,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
