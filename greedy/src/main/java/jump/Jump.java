package jump;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/19 16:40
 * @Description:
 */
public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n==1){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        while (left<=right&&right<=n-1) {
            res++;
            int temp = right;
            for (int i = left; i <= right; i++) {
                temp = Integer.max(temp,i+nums[i]);
                if (temp>=n-1){
                    return res;
                }
            }
            left =left+1;
            right = temp;
//            System.out.println(left);
//            System.out.println(right);
        }
        return res;
    }
}
