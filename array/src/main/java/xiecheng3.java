import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/14 19:50
 * @Description:
 */
public class xiecheng3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n =  in.nextInt();
            int []num = new int[n];
            LinkedList<Integer>a = new LinkedList<>();
            LinkedList<Integer>b = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                num[i] = in.nextInt();
            }
            in.nextLine();
            String str = in.nextLine();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i)=='R'){
                    a.add(num[i]);
                }
                else {
                    b.add(num[i]);
                }
            }
            int mina = Integer.MAX_VALUE;
            int minb = Integer.MAX_VALUE;
            int maxa = Integer.MIN_VALUE;
            int maxb = Integer.MIN_VALUE;
            for (int i = 0; i < a.size(); i++) {
                mina = Integer.min(mina,a.get(i));
                maxa = Integer.max(maxa,a.get(i));
            }
            for (int i = 0; i < b.size(); i++) {
                minb = Integer.min(minb,b.get(i));
                maxb = Integer.max(maxb,b.get(i));
            }
            int res = 0;
            if (mina==minb){
                res = Integer.max(maxa,maxb)-mina;
                System.out.println(res);
            }
            else if (mina<minb){
               maxa+=minb-maxa;
               res = Integer.max(maxa,maxb)-mina;
               System.out.println(res);
            }
            else{
                maxb+=mina-maxb;
                res = Integer.max(maxa,maxb)-mina;
                System.out.println(res); 
            }
        }
    }
}
