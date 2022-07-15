package bipartite;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/15 11:37
 * @Description:
 */
public class BFS {
    Queue<Integer>q;
    boolean []visited;
    //false表示黄色，true表示蓝色
    boolean []color;
    public boolean isBipartite(int[][] graph) {
        q = new LinkedList<>();
        visited = new boolean[graph.length];
        color = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]){
                q.offer(i);
            }
            while (!q.isEmpty()){
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    Integer cur = q.poll();
                    visited[cur] = true;
                    for (int j : graph[cur]) {
                        if (!visited[j]){
                            color[j] = !color[cur];
                            q.offer(j);
                        }
                        else {
                            if (color[j]==color[cur]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return  true;
    }
    
}
