import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/17 20:23
 * @Description:
 */
public class jingdong3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int []num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        HashMap<Integer, Integer>map =new HashMap<>();
        HashSet<Integer>set = new HashSet<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        int res = 0;
        for (int i = 0; i <k; i++) {
            if (num[i]>k||set.contains(num[i])){
                l1.add(i);
            }else {
                l2.add(i);
                set.add(num[i]);
            }
        }
        for (int i = 0; i <k; i++) {
            
        }
        int j = 0 ;
        for (int i = k; i < n; i++) {
            if (num[i]<=k&&!set.contains(i)){
                res+=i-l1.get(j);
                set.add(num[i]);
                j++;
            }
        }
        System.out.println(res);
    }
}
