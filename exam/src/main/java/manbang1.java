import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/6 19:15
 * @Description:
 */
public class manbang1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.charAt(0)!='1'||s.length()==1){
            System.out.println(-1);
            System.exit(0);
        }
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)!='3'){
                System.out.println(-1);
                System.exit(0);  
            }
            res++;
        }
        System.out.println(res);
    }
}
