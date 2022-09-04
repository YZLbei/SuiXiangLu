import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/4 19:37
 * @Description:
 */
public class didi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int []l = new int[T];
        int []r = new int[T];
        
        int []t = new int[T];
        for (int i = 0; i < T; i++) {
            l[i] = in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            r[i] = in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            t[i] = in.nextInt();
        }
        Arrays.fill(dp,Integer.MIN_VALUE);
        for (int i = 0; i < T; i++) {
            if (i!=T-1){
                System.out.print(res(l[i], r[i], t[i])+" ");
            }
            else {
                System.out.print(res(l[i], r[i], t[i]));
            }
//            System.out.println("map"+map.size());
        }
    }
    static public long []dp = new long[70001];
   static HashMap <Integer,Integer> map = new HashMap();
    static long res(int l, int r ,long t){
        long res = 0;
        for (int i = l; i <=r; i++) {
            long a = XOR(i);
            if (a==t){
                res++;
            }
        }
//        System.out.println();
//        System.out.println(map.get(2));
        return res;
    }
    static public int XOR(int num){
        System.out.println("xianzaidenum是"+num);
        if (map.containsKey(num)){
            System.out.println("num"+num);
            return map.get(num);
        }
        int res;
        res = num%10;
        num = num/10;
        while (num/10!=0){
            res ^= num%10;
            num = num/10;
        }
        if (num!=0){
            res = res^num;
        }
        dp[num] = res;
        map.put(num,res);
        System.out.println("map的长度是"+map.size());
        return res;
    }
}
