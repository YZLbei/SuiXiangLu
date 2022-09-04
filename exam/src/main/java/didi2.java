import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/4 19:54
 * @Description:
 */
public class didi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        float []a = new float[n+1];
        a[0] = 0;
        for (int i = 1; i <=n; i++) {
            a[i] = in.nextFloat();
        }
        Arrays.sort(a);
        float sum = 0;
        for (int i = 0; i <=n; i++) {
            sum +=a[i];
        }
        float avg = sum/n;
        float max = a[n];
        int i = n;
        while (max>k*avg&&i>=1){
            sum-=a[i];
            avg = sum/i;
            i--;
            max = a[i];
        }
        System.out.println(i);
    }
    
}
