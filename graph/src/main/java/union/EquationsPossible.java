package union;

import java.util.ArrayList;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/20 09:58
 * @Description:
 */
public class EquationsPossible {
    public class UF{
        int[] parent;
        public UF(int n){
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x){
            if (parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP==rootQ) {
                return;
            }
            parent[rootP] = rootQ;
        }
        public boolean connected(int p, int q ){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP==rootQ;
        }
    }
    public boolean equationsPossible(String[] equations) {
        UF uf =new UF(26);
        for (int i = 0; i < equations.length; i++) {
           if (equations[i].charAt(1)=='='){
               int a = equations[i].charAt(0)-'a';
               int b = equations[i].charAt(3)-'a';
               uf.union(a,b);
           }
        }
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1)=='!'){
                int a = equations[i].charAt(0)-'a';
                int b = equations[i].charAt(3)-'a';
                if (uf.connected(a,b)){
                    return false;
                }
            }
        }
        return true;
    }
}
