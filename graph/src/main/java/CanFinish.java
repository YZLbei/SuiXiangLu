import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/11 11:29
 * @Description:
 */
public class CanFinish {
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    
    List<Integer>[]graph;
    Boolean res = true;
    public void buildGraph(int numCourses, int[][] prerequisites){
        //图中有numCourses个节点
        graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            graph[from].add(to);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses,prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }
        return res;
    }
    public void traverse(int s){
        if (onPath[s]){
            res = false;
        }
        if (visited[s]||!res){
            return ;
        }
        visited[s] = true;
        onPath[s] = true;
        //不能这么写，这样写是遍历到某个节点，可能会漏掉成环的点
        for (Integer i : graph[s]) {
            traverse(i);
        }
        // 后序代码位置
        onPath[s] = false;
    }
    
}
