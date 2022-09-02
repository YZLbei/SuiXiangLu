import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/2 10:23
 * @Description:
 */
public class gaotu2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a==0||b==0||c==0){
            System.out.println("false");
        }
//        if (Math.pow(a,2)+Math.pow(b,2)>Math.pow(c,2)){
//            System.out.println("true");
//        }
        else {
            if (a + b > c && a + c > b && b + c > a && a - b < c && a - c < b && b - c < a) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
