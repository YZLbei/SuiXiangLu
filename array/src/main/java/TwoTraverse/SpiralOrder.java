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
        //res.size =m*n ����������������
        while (res.size()<m*n){
            if (upper_bound<=lower_bound){
                //�ڶ����������ұ���
                for (int i = left_bound; i <=right_bound; i++) {
                    res.add(matrix[upper_bound][i]);
                }
                //�ϱ߽�����
                upper_bound++;
            }
            
            if (left_bound<=right_bound){
                //���Ҳ���ϵ��±���
                for (int i = upper_bound; i <=lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                //�ұ߽�����
                right_bound--;
            }
            
            
            //�ڵײ������������
            if (upper_bound<=lower_bound){
                for (int i = right_bound; i >= left_bound; i--) {
                    res.add(matrix[lower_bound][i]);
                }
                lower_bound--;
            }
            
            
            //�������ϵ��±���
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
