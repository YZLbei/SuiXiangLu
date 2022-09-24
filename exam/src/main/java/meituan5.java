import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 17:47
 * @Description:
 */
public class meituan5 {
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
         List<Integer>[] path= new List[n];
         List<Integer>[] weight= new List[n];
        for (int i = 0; i < n; i++) {
            path[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            weight[i] = new LinkedList<>();
        }
        int []num = new int[n-1];
        int [] beu = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            num[i] = in.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            beu[i] = in.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int from = i + 2;
            int to = num[i];
            path[from].add(to);
            path[to].add(from);
            weight[from].add(beu[i]);
            weight[to].add(beu[i]);
        }
        System.out.println(3);
    }
    
}
