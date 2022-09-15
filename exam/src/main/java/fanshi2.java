import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/15 21:27
 * @Description:
 */
public class fanshi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            int []num = new int[n+1];
            for (int i = 1; i <=n; i++) {
                num[i] = in.nextInt();
            }
            if (k==1){
                System.out.println((n-1)/2);
            }
            else {
                int temp=0;
                for (int i = 2; i < n-1; i++) {
                    if (num[i]>num[i-1]+num[i+1]){
                        temp++;
                    }
                }
                System.out.println(temp);
            }
        }
    }
}
