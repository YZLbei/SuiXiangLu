public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int [][]result = new int[n][n];
        int circle = n/2;
        
        int count = 1;
        int start = 0;
        int end =n-1;
        //左闭右开
        for (int i = 0; i < circle; i++) {
            //从左向右
            //start =1 end=2
            for (int j = start; j < end; j++) {
                result[i][j] = count++;
                System.out.print("["+i+"]"+"["+j+"]"+result[i][j]);
            }
            System.out.println();
            //从上到下
            for (int j = start; j < end; j++) {
                result[j][end] = count++;
                System.out.print("["+j+"]"+"["+end+"]"+result[j][end]);
            }
            System.out.println();
            //从右到左
            for (int j = end; j >i ; j--) {
                result[end][j] =count++;
                System.out.print("["+end+"]"+"["+j+"]"+result[end][j]);
            }
            System.out.println();
            //从下到上
            for (int j = end; j >i ; j--) {
                result[j][i] = count++;
                System.out.print("["+j+"]"+"["+i+"]"+result[j][i]);
            }
            System.out.println();
            start = start+1;
            end = end-1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]+" ");       
            }
            System.out.println();
        }
        if (n%2!=0){
            System.out.println("ddddddddd");
            result[n/2][n/2]=n*n;
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateMatrix_59 g = new GenerateMatrix_59();
        g.generateMatrix(5);
    }
}
