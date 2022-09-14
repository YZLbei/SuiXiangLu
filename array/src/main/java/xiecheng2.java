import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/14 19:33
 * @Description:
 */
public class xiecheng2 {
    public static void main(String[] args) {
        System.out.println(5/2);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        float k = in.nextFloat();
        float square = n*n;
        if (k%2==0){
            float f= square/((k/2)*(k/2));
            System.out.println(String.format("%.2f",f));
        }else {
            if (k==1){
                System.out.println(String.format("%.2f",square/2));
            }
            else {
                int a = (int)k / 2;
                float b = a + 1;
                float f = square / ((a + 1) * (b + 1));
                System.out.println(String.format("%.2f", f));
            }
        }
    }
}
