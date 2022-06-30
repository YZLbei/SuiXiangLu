package TwoPointers.FastSlow;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/25 10:36
 * @Description:
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
