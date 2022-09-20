import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/20 19:16
 * @Description:
 */
public class xiaomi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer>start = new ArrayList<>();
        ArrayList<Integer>end = new ArrayList<>();
        while (in.hasNextInt()){
            start.add(in.nextInt());
            end.add(in.nextInt());
        }
        int [][]num = new int[start.size()][2];
        int n =  start.size();
        for (int i = 0; i < n; i++) {
            num[i][0] = start.get(i);
            num[i][1] = end.get(i);
        }
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                else {
                    return o1[0]-o2[0];
                }
            }
        });
        int res = 0;
        int edge = 0;
        for (int i = 0; i < n; i++) {
            if (num[i][0]<edge){
                if (num[i][1]<=edge){
                    continue;
                }
                res+=num[i][1]-edge;
                edge = num[i][1];
            }
            else {
                res += num[i][1] - num[i][0];
                edge= num[i][1];
            }
        }
        System.out.println(res);
    }
}
