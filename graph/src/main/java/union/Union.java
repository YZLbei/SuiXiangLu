package union;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/20 09:30
 * @Description:
 */
public class Union {
    //连通分量
    private int count;
    //存储每个节点的父节点
    private int[]parent;
    
    public Union(int n){
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    //将节点p和q连通
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP==rootQ){
            return;
        }
        parent[rootP] = rootP;
        count--;
    }
    
    //找到节点的根节点
    public int find(int x){
        while (parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return x;
    }
    
    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP==rootQ;
    }
    
    public int count(){
        return count;
    }
    
}
