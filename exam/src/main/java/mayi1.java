import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/27 19:28
 * @Description:
 */
public class mayi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        res = new int[n];
        used = new boolean[n+1];
        prime = new boolean[2*n+1];
        for (int i = 1; i <=2*n; i++) {
            if (!isPrime(i)){
                prime[i] =false;
            }
            else {
                prime[i]  =true;
            }
        }
        boolean dfs = dfs(n, 1);
        if (!dfs){
            System.out.println(-1);
        }
        else {
            for (int i = 0; i <n-1; i++) {
                System.out.print(res[i]+" ");
            }
            System.out.println(res[n-1]);
        }
    }
    static int[]res;
    static boolean[]used;
    static boolean[] prime;
    static boolean isPrime(int n){
        if (n<=3){
            return n>1;
        }
        int s = (int)Math.sqrt(n);
        for (int i = 2; i <=s; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
   static public boolean dfs(int n ,int index){
        if (n+1==index){
            return true;
        }
        for (int i = 1; i <=n; i++) {
            if (used[i]){
                continue;
            }
            if (!prime[index+i]){
                res[index-1] = i;
                used [i] = true;
                boolean dfs = dfs(n, index + 1);
                used[i] = false;
                if (dfs){
                    return true;
                }
            }
        }
        return false;
    }
    
}
