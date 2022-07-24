package merge;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/24 17:24
 * @Description:
 */
public class CountSmaller {
    private class Pair{
        int val;
        int id;
        public Pair(int val,int id){
            this.val = val;
            this.id = id;
        }
    }
    Pair[]temp;
    int []res;
    public List<Integer> countSmaller(int[] nums) {
        temp =new Pair[nums.length];
        res = new int[nums.length];
        Pair []arr = new Pair[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Pair(nums[i],i);
        }
        sort(arr,0,nums.length-1);
        List<Integer>result = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            result.add(res[i]);
        }
        return result;
    }
    public void sort(Pair[]nums,int low,int high){
        if (low==high){
            return;
        }
        int mid = low +(high-low)/2;
        sort(nums,low,mid);
        sort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    public void merge(Pair[]nums,int low ,int mid ,int high){
        for (int i = low; i <=high; i++) {
            temp[i]= nums[i];
        }
        int i = low;
        int j = mid+1;
        for (int k = low; k <=high; k++) {
            if (i==mid+1){
                nums[k] = temp[j++];
            }
            else if(j ==high+1){
                nums[k] = temp[i++];
                res[nums[k].id] +=j-mid-1;
            }
            else if (temp[i].val<=temp[j].val){
                nums[k] = temp[i++];
                res[nums[k].id] +=j-mid-1;
            }
            else {
                nums[k] = temp[j++];
            }
        }
    }
}
