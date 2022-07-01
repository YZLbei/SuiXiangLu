package PreSum;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/30 16:14
 * @Description:
 */
public class Two {
    class NumMatrix {
        /**
         * 前缀和数组为0，0为左上角
         */
        int[][]preSum;
        public NumMatrix(int[][] matrix) {
            preSum = new int[matrix.length+1][matrix[0].length+1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    preSum[i+1][j+1] = matrix[i][j] + preSum[i][j+1]+preSum[i+1][j]-preSum[i][j];
                }
            }
            // for (int i = 0; i < preSum.length; i++) {
            //     for (int j = 0; j < preSum[0].length; j++) {
            //         System.out.print(preSum[i][j]+" ");
            //     }
            //     System.out.println();
            // }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2+1][col2+1]-preSum[row2+1][col1]-preSum[row1][col2+1]+preSum[row1][col1];
        }
    }
}
