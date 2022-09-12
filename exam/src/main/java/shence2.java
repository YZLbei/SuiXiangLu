

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/12 19:21
 * @Description:
 */
public class shence2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            transfer(str);
        }
    }
    static public void transfer(String str) {
        int n = str.length();
        if (n==0){
            System.out.println(-1);
            return;
        }
        if (str.charAt(0) == '.' || str.charAt(n - 1) == '.' || str.charAt(0) == '0') {
            System.out.println(-1);
            return;
        } 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i <= n - 1 && str.charAt(i) == '.' && str.charAt(i + 1) == '.') {
                    sb.append(".");
                    sb.append("0");
                } else {
                    sb.append(str.charAt(i));
                }
            }
            String[] split = sb.toString().split("\\.");
            if (split.length!=7){
                System.out.println(-1);
                return;
            }
            long res = 0;
            for (int i = 6; i >= 0; i--) {
//                if (!split[i].matches("[0-255]")) {
//                    System.out.println(-1);
//                    return;
//                }
                long ip = Long.parseLong(split[6 - i]);
                if (ip > 255) {
                    System.out.println(-1);
                    return;
                }
                res |= ip << (i * 8);
            }
            System.out.println(res);
    }
}
