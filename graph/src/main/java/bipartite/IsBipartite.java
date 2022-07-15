package bipartite;

import sun.java2d.loops.FillSpans;

import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/15 10:44
 * @Description:
 */
public class IsBipartite {
    Boolean res = true;
    Boolean[]visited;
    //0表示没着色，1表示黄色，2表示蓝色
    int[] color;
    public boolean isBipartite(int[][] graph) {
        visited =new Boolean[graph.length];
        Arrays.fill(visited, false);
        color = new int[graph.length];
        Arrays.fill(color,0);
        
        for (int i = 0; i < graph.length; i++) {
            if (color[i]==0){
                color[i]=1;
            }
            if (!visited[i]){
                traverse(graph,i); 
            }
        }
        return res;    
    }
    
    public void traverse(int [][]graph,int v){
        if (!res){
            return;
        }
        visited[v] = true;
        for (int i : graph[v]) {
            //如果没有遍历过，就跟v着相反颜色
            if (!visited[i]){
                if (color[v]==1){
                    color[i]=2;
                }
                else if (color[v]==2){
                    color[i] =1;
                }
                traverse(graph,i);
            }
            //如果遍历过，判断和v颜色是否相同，相同说明不是二分图
            else {
                if (color[i]==color[v]){
                    System.out.println("i:"+i);
                    System.out.println("v:"+v);
                    res = false;
                }
            }
        }
    }
}
