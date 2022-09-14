import java.util.Scanner;

/**
 * @Auther: YuZhendouble
 * @Date: 2022/9/14 20:25
 * @Description:
 */
public class xiecheng4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        System.out.println((int)sum(n)%1000000007);
    }
    static  double sum(double n){
        double sum =0;
        double k = n*4-4;
        int sum1 = 0;
        for (double i = 1; i <=4; i++) {
            sum1+=i;
        }
        sum+=sum1*2;
        double sum2 = 0;
        for (double i = 5; i <=k; i++) {
            sum2+=i;
        }
        sum+= sum2*3;
        double sum3 = 0;
        for (double i = k+1;i <=n*n; i++) {
            sum3+=i;
        }
        sum+=sum3*4;
        return sum;
    }
}
