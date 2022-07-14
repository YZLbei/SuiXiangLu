package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/14 10:49
 * @Description: BFS拓扑排序
 */
public class FindOrder {
    List<Integer>[]graph;
    int[]indegree;
    List<Integer>res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //graph = new LinkedList<>();
        bulidGraph(numCourses,prerequisites);
        bulidIndegree(numCourses,prerequisites);
        res = new LinkedList<>();
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            Integer cur = q.poll();
            res.add(cur);
            count++;
            for (Integer i : graph[cur]) {
                indegree[i]--;
                if (indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        if (count!=numCourses){
            return new int[]{};
        }
        int length = res.size();
        int []result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    public void bulidGraph(int numCourses, int[][] prerequisites){
        graph =new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
        }
    }

    public void bulidIndegree(int numCourses, int[][] prerequisites){
        indegree = new int[numCourses];
        for (int[] num : prerequisites) {
            indegree[num[0]]++;
        }
    }
}
