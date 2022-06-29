package TwoPointers.LeftRight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/29 17:12
 * @Description:
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int []result = new int[2];
        int left = 0 ;
        int right = numbers.length-1;
        int sum;
        
        
        while (left<=right){
            sum =numbers[left]+numbers[right];
            if (sum==target){
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            else if (sum<target){
                left++;
            }
            else {
                right--;
            }
        }
        return result;
    }
}
