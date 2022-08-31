import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/31 21:49
 * @Description:
 */
public class guanglianda2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][]reg = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                reg[i][j] = in.nextInt();
            }
        }
        Arrays.sort(reg,(a,b)->{
            if (a[0]==b[0]){
                return a[1]-b[1];
            }
            else {
                return a[0]-b[0];
            }
        });
        int res = n;
        int lastEnd = 1;
        int curEnd = 1;
        int lastEdge =1;
        for (int i = 0; i < m; i++) {
            int l = reg[i][0];
            int r = reg[i][1];
            lastEdge = r;
            int x = reg[i][2];
            if (l>lastEnd){
                curEnd = l;
            }
            if (curEnd+x-1<=r){
                res-=r-curEnd-x+1;
                lastEnd = r+1;
            }
            else {
                if (x>r-l+1){
                    continue;
                }
                else {
                    if (lastEdge-lastEnd+1>=r-l+1){
                        continue;
                    }
                    else{
                        res-=(r-l)-(lastEdge-lastEnd)+1;
                    }
                }
            }
            
        }
        System.out.println(res);
    }
}
