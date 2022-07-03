package TwoTraverse;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/3 10:33
 * @Description:
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upper_bound = 0,lower_bound = m-1;
        int left_bound = 0,right_bound = n-1;
        List<Integer>res = new ArrayList<>();
        //res.size =m*n 即遍历完整个数组
        while (res.size()<m*n){
            if (upper_bound<=lower_bound){
                //在顶部从左向右遍历
                for (int i = left_bound; i <=right_bound; i++) {
                    res.add(matrix[upper_bound][i]);
                }
                //上边界下移
                upper_bound++;
            }
            
            if (left_bound<=right_bound){
                //在右侧从上到下遍历
                for (int i = upper_bound; i <=lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                //右边界左移
                right_bound--;
            }
            
            
            //在底部从右向左遍历
            if (upper_bound<=lower_bound){
                for (int i = right_bound; i >= left_bound; i--) {
                    res.add(matrix[lower_bound][i]);
                }
                lower_bound--;
            }
            
            
            //在左侧从上到下遍历
            if (left_bound<=right_bound){
                for (int i = lower_bound; i >=upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
            left_bound++;
            }
        }
        return res;
    }
}
