import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/2 19:46
 * @Description:
 */
public class oppo1 {
    public int maxDigit (int[] digits) {
        // write code here
        int res = 0;
        int n = digits.length;
        Arrays.sort(digits);
        for (int i = n-1; i >=0; i--) {
            res = res*10+digits[i];
        }
        return res;
    }
}
