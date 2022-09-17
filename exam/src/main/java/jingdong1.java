import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/17 19:34
 * @Description:
 */
public class jingdong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a>b+1){
            System.out.println(-1);
        }
        else {
            int []num = new int[a+b+1];
            int temp = a;
            for (int i = 1; i <=a+b; i++) {
                if (i%2==1&&temp>0){
                    num[i] = 1;
                }
                else {
                    num[i] =2;
                }
            }
            for (int i = 1; i<=a+b; i++) {
                if (i!=a+b) {
                    System.out.print(num[i] + " ");
                }
                else {
                    System.out.print(num[i]);
                }
            }
        }
    }
}
