import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/31 17:00
 * @Description:
 * 999999999
 */
public class shunfeng1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long input = in.nextInt();
        long n= input;
        long res = 0;
        for (long i = 0; i < input; i++) {
            if ((n%2)==0){
               res+= even(n);
            }
            else {
                res+= odd(n);
            }
            n--;
        }
        System.out.println(res);
    }
    
    static int odd(long n){
        int res = 0;
        while (n%2!=0){
            if (n==1){
                return 1;
            }
            if (n==2){
                return 2;
            }
            if (n==3){
                return 3;
            }
            if (n==4){
                return 3;
            }
            
            n = n/2+1;
            res++;
        }
        return res;
    }

    static int even(long n){
        int res = 0;
        while (n%2!=0){
            if (n==1){
                return 1;
            }
            if (n==2){
                return 2;
            }
            if (n==3){
                return 3;
            }
            if (n==4){
                return 3;
            }
            n = n/2;
            res++;
        }
        return res;
    }
}
