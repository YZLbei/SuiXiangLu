

import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/11 20:24
 * @Description:
 */
public class weilai1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int num = 0;
            int j = 3;
            while (j-->0) {
                if (in.nextInt() == 6) {
                    num++;
                }
            }
            if (num==3){
                System.out.println(2000);
            }
            else if(num==2){
                System.out.println(1000);
            }
            else if (num==1){
                System.out.println(500);
            }
            else {
                System.out.println(100);
            }
            
        }
    }
}
