package dichotomy;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/6 08:48
 * @Description:
 */
public class Left_bound {
    int left_bound(int []nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                right = mid-1;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        if (left>=nums.length||nums[left]!=target){
            return -1;
        }
        return left;
    }
}
