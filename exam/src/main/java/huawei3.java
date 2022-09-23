import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/23 19:08
 * @Description:
 */
public class huawei3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int [][]path = new int[n][2];
        for (int i = 0; i < n; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            path[i][0] = from;
            path[i][1] = to;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Check c = new Check(m);
            for (int j = 0; j < n; j++) {
                if (i==j){
                    continue;
                }
                c.connect(path[j][0],path[j][1]);
            }
            if (c.count!=1){
                res++;
            }
        }
        System.out.println(res);
       
    }
    static class Check{
        int count;
        private int []parent;
        public Check(int m){
            this.count = m;
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
        }
        public int find(int i){
            if (parent[i]!=i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public int count(){
            return count;
        }
        public boolean isConnect(int p,int q){
            int root1 = find(p);
            int root2 = find(q);
            return root1==root2;
        }
        public void connect(int p,int q){
            int root1 = find(p);
            int root2 = find(q);
            if (root1==root2){
                return;
            }
            parent[root1] = root2;
            count--;
        }
    }
}
