import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/13 20:53
 * @Description:
 */
public class weizhong2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long []a = new long[n];
        long []b = new long[n];
        for (int i = 0; i <n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            long ai = a[i];
            long bi = b[i];
            if (ai==bi){
                System.out.println(0);
            }
            else{
                long max = 0;
                long min = 0;
                if (ai>bi){
                    max = ai;
                    min = bi;
                }
                else {
                    max = bi;
                    min = ai;
                }
                if (max%min!=0){
                    System.out.println(-1);
                }
                else {
                    long num = max/min;
                    if (!judje(num)){
                        System.out.println(-1);
                    }
                    else {
                        long k = dfs(max, min);
                        if (k==0){
                            System.out.println(-1);
                        }
                        else {
                            System.out.println(k);
                        }
                    }
                }
            }
            
        }
    }
    static boolean judje(long num){
        if ((num&(num-1))==0){
            return true;
        }
        else {
            return false;
        }
    }
    //static int res;
    static long dfs(long a,long b){
        int res = 0;
        while (a!=b){
            if (b*8<=a){
                b =b*8;
            }
            else if (b*4<=a){
                b =b*4; 
            }
            else {
                b = b*2;
            }
            res++;
        }
        return res;
    }
}
