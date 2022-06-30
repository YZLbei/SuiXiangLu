package PreSum;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/30 15:36
 * @Description:
 */
public class One {
    class NumArray {
        //Ç°×ººÍ
        int []preSum;
        public NumArray(int[] nums) {
            preSum = new int[nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                preSum[i+1] = preSum[i]+nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right+1]-preSum[left];
        }
    }
}
