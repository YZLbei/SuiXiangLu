import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/8 08:19
 * @Description:BFS思路,会超时，应该用dijkstra
 * 
 * Dijkstra就是求最短路径
 */
public class FindCheapestPrice {
    //建图
    List<Integer>[]graph;
    List<Integer>[]distance;
    public void buildGraph(int n,int [][]flights){
        graph = new LinkedList[n];
        distance = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
            distance[i] = new LinkedList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int dis = flights[i][2];
            graph[from].add(to);
            distance[from].add(dis);
        }
    }
    int []memo ;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        buildGraph(n, flights);
        //int []dp = new int[n];
        Queue<Integer>q = new LinkedList<Integer>();
        //跟q相对应，记录每个路径的值
        Queue<Integer> minDis  = new LinkedList<>();
        q.add(src);
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()&&k>=0){
            int size = q.size();
            k--;
            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();
                int lastDis;
                if (minDis.isEmpty()){
                     lastDis = 0;
                }
                else {
                     lastDis = minDis.poll();
                }
                for (int j = 0; j < graph[cur].size(); j++) {
                    Integer to = graph[cur].get(j);
                    Integer dis = distance[cur].get(j);
                    int curDis = lastDis+dis;
                    System.out.println(curDis);
                    if (to==dst){
                        result = Integer.min(result,curDis);
                    }
                    else {
                        q.add(to);
                        minDis.add(lastDis + dis);
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
