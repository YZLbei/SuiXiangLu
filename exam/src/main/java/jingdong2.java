import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/17 20:00
 * @Description:
 */
public class jingdong2 {
    public static void main(String[] args) {
        BigInteger mod  = new BigInteger(String.valueOf(1000000007));
        int m = 1000000007;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long []dp1= new long[n+1];
        long []dp2 = new long[n+1];
        dp1[3] = 1;
        dp2[3] = 1;
        dp2[4] = 52;
        dp2[5] = 26*26*3-1;
        for (int i = 4; i <=n; i++) {
            BigInteger bigInteger = new BigInteger("26");
            BigInteger num = bigInteger.pow(i-3);
            long temp = num.mod(mod).longValue();
            dp1[i] = (temp+26*dp1[i-1]-dp1[i-3]+m)%m;
        }
        for (int i = 6; i <=n; i++) {
            BigInteger bigInteger = new BigInteger("26");
            BigInteger num1 = bigInteger.pow(i-5);
            BigInteger num2 = bigInteger.pow(i-3);
            long tem1 = num1.mod(mod).longValue();
            long tem2 = num2.mod(mod).longValue();
            dp2[i] = (dp1[i]-(i-4)*tem1+(i-5)*tem2+m)%m;
        }
        System.out.println(dp2[n]);
    }
}
