package TwoPointers.LeftRight;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/29 20:27
 * @Description:
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
