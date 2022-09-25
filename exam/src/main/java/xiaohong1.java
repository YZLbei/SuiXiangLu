import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/25 16:59
 * @Description:
 */
public class xiaohong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []num= new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        int res = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i]-res==1){
                res = num[i];
            }
            else if(num[i]==res){
                continue;
            }
            else {
                break;
            }
        }
        System.out.println(res);
    }
}
