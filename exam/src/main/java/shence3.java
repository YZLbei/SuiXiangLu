import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/12 20:15
 * @Description:
 */
public class shence3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][]road = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            road[i][0] = in.nextInt();
            max = Integer.max(max,road[i][0]);
            road[i][1] = in.nextInt();
            max = Integer.max(max,road[i][1]);
        }
        int a = in.nextInt();
        int b = in.nextInt();
        graph = new List[max+1];
        for (int i = 0; i <=max; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            int from = road[i][0];
            int to = road[i][1];
            graph[from].add(to);
        }
        StringBuilder roadCur = new StringBuilder();
        roadCur.append(a);
        dfs(a,roadCur,false);
        roadCur = new StringBuilder();
        roadCur.append(b);
        dfs(b,roadCur,true);
        for (int i = 0; i < roadA.size(); i++) {
            System.out.println(roadA.get(i));
        }
        for (int i = 0; i < roadB.size(); i++) {
            System.out.println(roadB.get(i));
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < roadA.size(); i++) {
            for (int j = 0; j < roadB.size(); j++) {
                for (int k = 0; k < roadA.get(i).length(); k++) {
                    if (roadB.get(j).contains(String.valueOf(roadA.get(i).charAt(k)))){
                        if (Integer.parseInt(String.valueOf(roadA.get(i).charAt(k)))<min){
                            min = Integer.parseInt(String.valueOf(roadA.get(i).charAt(k)));
                            res = Integer.parseInt(String.valueOf(roadA.get(i).charAt(k)));
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
   static List<Integer>[] graph;
   static LinkedList<String> roadA = new LinkedList<>();
   static LinkedList<String> roadB = new LinkedList<>();
    static public void  dfs(int from,StringBuilder road,boolean flag){
        if (graph[from].contains(1)){
            road.append("1");
            if (!flag) {
                roadA.add(new String(road));
            }
            else {
                roadB.add(new String(road));
            }
            return ;
        }
        for (int i = 0; i < graph[from].size(); i++) {
            StringBuilder temp = new StringBuilder(road);
            temp.append(graph[from].get(i));
            dfs(graph[from].get(i), temp, flag);
        }
        
    }
}
