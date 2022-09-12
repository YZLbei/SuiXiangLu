import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/12 19:03
 * @Description:
 */
public class shence1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []num1 = new int[n];
        int []num2 = new int[n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            num1[i] = a+i;
            num2[i] = a-i;
        }
        int res = -1;
        int max = num1[0];
        for (int i = 1; i < n; i++) {
            res = Integer.max(res,max+num2[i]);
            max = Integer.max(max,num1[i]);
        }
        System.out.println(res);
        
    }
}
