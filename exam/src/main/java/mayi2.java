import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/27 19:57
 * @Description:
 */
public class mayi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int []num = new int[n];
        if (k==0){
            System.out.println(-1);
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            map.put(num[i],map.getOrDefault(num[i],0)+1);
        }
        //System.out.println(map.size());
        Arrays.sort(num);
        int res = 0;
//        for (Integer i : map.keySet()) {
//            System.out.println(map.get(i));
//        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(num[i])&&map.get(num[i])>1){
                int count = change(num[i],k);
                res+=count;
            }
        }
        System.out.println(res);
        
    }
   static HashMap<Integer, Integer> map = new HashMap<>();
    static int change(int a,int k){
        map.put(a,map.get(a)-1);
        int count  =1;
        a+=k;
        while (map.containsKey(a)&&map.get(a)>=1){
            count++;
            a+=k;
        }
        map.put(a,1);
        return  count;
    }
}
