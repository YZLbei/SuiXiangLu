import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/27 20:20
 * @Description:
 */
public class mayi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][]num = new int[n][m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num[i][j] = in.nextInt();
                sum+= num[i][j];
            }
        }
        int q = in.nextInt();
        int [][] d = new int[q][4];
        System.out.println(sum+q);
    }
}
