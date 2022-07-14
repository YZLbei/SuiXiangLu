package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/14 10:30
 * @Description:
 */
public class CanFinish {
    List<Integer>[]graph;
    int[]indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //graph = new LinkedList<>();
        bulidGraph(numCourses,prerequisites);
        bulidIndegree(numCourses,prerequisites);
        int count = 0;
        Queue<Integer>q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            Integer cur = q.poll();
            count++;
            for (Integer i : graph[cur]) {
                indegree[i]--;
                if (indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        return count==numCourses;
    }
    public void bulidGraph(int numCourses, int[][] prerequisites){
        graph =new  LinkedList[numCourses];
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
