package BFS;


import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/12 20:31
 * @Description:
 */
public class Frame {
    class Node{
        int val;
        //相邻节点
        List<Node>adj(){
            List<Node>neighbors = new LinkedList<>();
            return neighbors;
        }
    }
    //计算从起点start到终点target的最短距离
    int BFS(Node start, Node target) {
        //核心数据结构
        Queue<Node>q = new LinkedList<>();
        //避免走回头路
        Set<Node> visited = new HashSet<Node>();
        // 将起点加入队列
        q.offer(start);
        visited.add(start);
        //记录扩散的步数
        int step = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            //将当前队列中所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                //重点，判断是否到达终点
                if (cur ==target){
                    return step;
                }
                //将cur的相邻节点加入队列
                for (Node node : cur.adj()) {
                    if (visited.contains(node)){
                        q.offer(node);
                        visited.add(node);
                    }
                }
            }
            //重点，在这里更新步数
            step++;
        }
        return step;
    }
}
