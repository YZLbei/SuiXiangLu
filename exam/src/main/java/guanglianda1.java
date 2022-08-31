import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/31 21:30
 * @Description:
 */
public class guanglianda1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []start = new int[n];
        int []end = new int[n];
        HashMap<Integer, Integer>map1 = new HashMap<>();
        HashMap<Integer, Integer>map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            start[i] = in.nextInt();
            map1.put(start[i],i);
        }
        for (int i = 0; i < n; i++) {
            end[i] = in.nextInt();
            map2.put(end[i],i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Integer temp = map1.get(end[i]);
            //System.out.println(temp);
            for (int j = 0; j <temp; j++) {
                if (i<map2.get(start[j])){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
