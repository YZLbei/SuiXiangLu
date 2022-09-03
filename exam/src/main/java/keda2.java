import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/3 19:22
 * @Description:
 */
public class keda2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int M = in.nextInt();
        int [][]dis = new int[M][2];
        for (int i = 0; i < M; i++) {
            dis[i][0] = in.nextInt();
            dis[i][1] = in.nextInt();
        }
        Arrays.sort(dis,(a,b)->{
            if (a[0]==b[0]){
                return b[1]-a[1];
            }
            else {
                return a[0]-b[0];
            }
        });
        int res = 1;
        if (dis[0][0]!=1){
            System.out.println("fail");
            System.exit(0);
        }
        int curEnd = 1;
        int nextEnd = 1;
        int i = 0;
        while (i<M&&dis[i][0]<=curEnd){
            while (i<M&&dis[i][0]<=curEnd){
                nextEnd = Math.max(nextEnd,dis[i][1]);
                i++;
            }
            res++;
            curEnd = nextEnd;
            if (curEnd>=L){
                System.out.println(res);
                System.exit(0);
            }
        }
        System.out.println("fail");
        System.exit(0);
    }
}
