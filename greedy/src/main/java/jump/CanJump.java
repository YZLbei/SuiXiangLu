package jump;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/19 16:35
 * @Description:
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        //最大能到的位置
        int edge = 0;
        for (int i = 0; i <=edge; i++) {
            edge = Integer.max(edge,i+nums[i]);
            if (edge>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
