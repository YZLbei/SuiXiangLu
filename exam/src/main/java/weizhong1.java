import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/13 20:30
 * @Description:
 */
public class weizhong1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        String []str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(num[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){
                    return 1;
                }
                else if (o1.length()<o2.length()){
                    return -1;
                }
                else {
                    int i = o1.compareTo(o2);
                    if (i>0){
                        return 1;
                    }
                    else if (i<0){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });
        int length = 0;
        if (n<3){
            length = n;
        }
        else {
            length = 3;
        }
        String []res  = new String[length];
        for (int i = 0; i < length; i++) {
            res[i] = str[n-i-1];
        }
        Arrays.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int i = length-1; i>=0; i--) {
            sb.append(res[i]);
        }
        System.out.println(sb);
    }
}
