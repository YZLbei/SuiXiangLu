import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/25 17:22
 * @Description:
 */
public class xiaohong3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] path = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            path[i] = in.nextInt();
        }
        int[] w = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            w[i] = in.nextInt();
        }
        graph g = new graph(n);
        for (int i = 0; i < n-1; i++) {
            g.addEdge(i+1,path[i],w[i]);
        }
//        for (int i = 0; i < n ; i++) {
//            Iterable<Edge> ite = g.ite(i);
//            for (Edge edge : ite) {
//                System.out.println(edge.b);
//            }
//        }
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int res  = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            sum  =Integer.MAX_VALUE;
            visited = new boolean[n];
            dfs(g, a-1, i,0);
            temp+=sum;
            sum  =Integer.MAX_VALUE;
            visited = new boolean[n];
            dfs(g, b-1, i,0);
            temp+=sum;
            sum  =Integer.MAX_VALUE;
            visited = new boolean[n];
            dfs(g, c-1, i,0);
            temp+=sum;
            res = Integer.min(res,temp);
        }
        System.out.println(res);
    }
    static boolean []visited;
    static int sum = Integer.MAX_VALUE;
    static public void dfs(graph g,int i,int to, int curSum){
        if (visited[i]){
            return;
        }
        visited[i] = true;
        if (i==to){
            sum  =Integer.min(sum,curSum);
            return ;
        }
        Iterable<Edge> ite = g.ite(i);
        for (Edge edge : ite) {
            dfs(g,edge.b,to,curSum+edge.weight);
        }
    }
}
    class Edge{
        public int a;
        public int b;
        public int weight;
        public Edge(int a,int b,int weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }
    }
    class graph{
        public int n;
        public int m;
        public Edge[][]g;
        public graph(int n){
            this.n = n;
            this.m = 0;
            g = new Edge[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = null;
                }
            }
        }
        public void addEdge(int a,int b,int weight){
            g[a][b]  = new Edge(a,b,weight);
            g[b][a]  = new Edge(b,a,weight);
            m++;
        }
        public Iterable<Edge>ite(int a){
            LinkedList<Edge> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (g[a][i]!=null){
                    list.add(g[a][i]);
                }
            }
            return list;
        }
    }

