import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/23 20:01
 * @Description:
 */
public class huawei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int []price = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            price[i] = in.nextInt();
            sum+=price[i];
        }
        if (sum%2!=0){
            System.out.println(0);
            System.exit(0);
        }
        int target = sum/2;
        BigInteger []dp= new BigInteger[target+1];
        for (int i = 1; i <=target; i++) {
            dp[i] = BigInteger.valueOf(0);
        }
        dp[0] = BigInteger.valueOf(1);
        for (int i = 0; i <m; i++) {
            for (int j = target; j >=price[i]; j--) {
                dp[j] = dp[j].add(dp[j - price[i]]) ;
            }
        }
        System.out.println(dp[target].mod(BigInteger.valueOf(1000000007)));
    }
}
