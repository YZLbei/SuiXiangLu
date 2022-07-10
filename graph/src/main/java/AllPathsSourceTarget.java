import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/10 10:17
 * @Description:
 */
public class AllPathsSourceTarget {
    List<Integer>onPath = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph,0);
        return res;
    }
    
    public void traverse(int[][]graph,int s){
        onPath.add(s);
        int n = graph.length-1;
        if (s==n){
            res.add(new ArrayList<>(onPath));
        }
        for (int i : graph[s]) {
            traverse(graph,i);
        }
        onPath.remove(onPath.size()-1);
    }
}
