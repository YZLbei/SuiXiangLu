package TwoTraverse;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/3 11:04
 * @Description:
 */
public class SpiralOrderII {
    public int[][] generateMatrix(int n) {
        //List<List<Integer>>Array = new ArrayList<>();
        int count = 1;
        int[][]res = new int[n][n];
        int upper_bound = 0,lower_bound = n-1;
        int left_bound = 0,right_bound = n-1;
        int length = n*n;
        while (count<=length){
            if (upper_bound<=lower_bound){
                for (int i = left_bound; i <=right_bound; i++) {
                    res[upper_bound][i] = count;
                    count++;
                }
                upper_bound++;
            }
            
            if (left_bound<=right_bound){
                for (int i = upper_bound; i <=lower_bound; i++) {
                    res[i][right_bound] = count++;
                }
                right_bound--;
            }
            
            if (upper_bound<=lower_bound){
                for (int i = right_bound; i >= left_bound; i--) {
                    res[lower_bound][i] = count++;
                }
                lower_bound--;
            }
            
            if (left_bound<=right_bound){
                for (int i = lower_bound; i >=upper_bound; i--) {
                    res[i][left_bound] = count++;
                }
                left_bound++;
            }
        }
        return res;
    }
}
