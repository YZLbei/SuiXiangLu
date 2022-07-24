package merge;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/24 16:33
 * @Description:
 */
public class Merge {
    //保存数组，用于merge操作
    int []temp;
    public void sort(int []nums){
        temp = new int[nums.length];
        sort(nums,0,nums.length-1);
    }
    
    public void sort(int[]nums,int low,int high){
        //单个元素不用排序
        if (low==high){
            return;
        }
        int mid = low+(high-low)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);
        merge(nums,mid,low,high);
    }
    //将两个有序数组合并
    public void merge(int[]nums,int mid ,int low ,int high){
        for (int i = low; i <=high; i++) {
            temp[i] = nums[i];
        }
        //双指针
        int i = low;
        int j = mid+1;
        for (int k = low; k <=high; k++) {
            if (i>mid){
                nums[k] = temp[j++];
            }
            else if(j>high){
                nums[k] = temp[i++];
            }
            else if(temp[i]<=temp[j]){
                nums[k] = temp[i++];
            }
            else{
                nums[k] = temp[j++];
            }
        }
    }
}
