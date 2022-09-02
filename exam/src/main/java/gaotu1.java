

import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/2 10:01
 * @Description:
 */
public class gaotu1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean []num = new boolean[10];
        int res= 0 ;
        if (n%10==0){
            while (n/10!=0){
                n = n/10;
            }
            res= n;
        }
        else {
            while (n!=0) {
                int a = n % 10;
                n = n / 10;
                if (!num[a]) {
                    res = res * 10 + a;
                    num[a] = true;
                }
            }
           // res +=res*10+n;
        }
        System.out.println(res);
    }
}
