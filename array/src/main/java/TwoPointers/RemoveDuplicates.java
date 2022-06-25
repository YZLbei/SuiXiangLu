package TwoPointers;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/25 09:27
 * @Description:
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0 ;
        for (int fast= 1; fast < nums.length; fast++) {
            if (nums[fast]!=nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
