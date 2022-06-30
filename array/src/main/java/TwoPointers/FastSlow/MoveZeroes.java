package TwoPointers.FastSlow;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/25 10:36
 * @Description: 移动零
 * 快慢指针法
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
