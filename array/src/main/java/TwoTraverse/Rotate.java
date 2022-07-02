package TwoTraverse;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/2 15:55
 * @Description:
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        //�Ȱ��նԽ��߷�ת
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //�ٽ�ÿһ�з�ת
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                int m = matrix[0].length-1-j;
                matrix[i][j] = matrix[i][m];
                matrix[i][m] = temp;
            }
        }
    }
}
