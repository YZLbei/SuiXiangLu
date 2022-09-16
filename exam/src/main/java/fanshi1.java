//import java.io.*;
//
///**
// * @Auther: YuZhenLong
// * @Date: 2022/9/15 21:01
// * @Description:
// */
//public class fanshi1 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s1 = br.readLine().split(" ");
//        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(s1[0]);
//            int m = Integer.parseInt(s1[1]);
//        StringBuilder []sb = new StringBuilder[n];
//            char [][]num = new char[n][m];
//            for (int i = 0; i < n; i++) {
//                String s2 = br.readLine();
//                for (int j = 0; j < m; j++) {
//                    num[i][j] = s2.charAt(j);
//                }
//            }
//            visited = new boolean[n][m];
//            res = new int[n][m];
//            for (int i = 0; i < n; i++) {
//                sb[i] = new StringBuilder();
//                for (int j = 0; j < m; j++) {
//                    if (num[i][j]=='.'){
//                        sb[i].append(".");
//                    }
//                    else {
//                        used = new boolean[n][m];
//                        result = 0;
//                        if ()
//                        int dfs = dfs(num, n, m, i, j, false);
//                        if (dfs!=0){
//                            res[i][j] = dfs;
//                        }
//                        else {
//                            res[i][j] = result;
//                        }
//                        sb[i].append(String.valueOf(res[i][j]%10));
//                    }
//                    visited[i][j] = true;
//                }
//            }
//        for (int i = 0; i < n; i++) {
//            out.println(sb[i]);
//            out.flush();
//        }
//        }
//        
//    static int [][]res;
//    static int result ;
//    static boolean  [][]used ;
//   static public void dfs(char [][]num,int n ,int m,int i ,int j,boolean flag){
//        if (i<0||i>=n||j<0||j>=m){
//            return 0;
//        }
//        if (num[i][j]=='*'&&flag){
//            return 0;
//        }
//        if ((num[i][j]=='.'&&!used[i][j])||(num[i][j]=='*'&&!flag)){
//            result++;
//            used[i][j] = true;
//            int a = dfs(num, n, m, i - 1, j, true);
//            if (a!=0){
//                return a;
//            }
//            int b = dfs(num,n,m,i+1,j,true);
//            if (b!=0){
//                return b;
//            }
//            int c =  dfs(num,n,m,i,j-1,true);
//            if (c!=0){
//                return c;
//            }
//            int d = dfs(num,n,m,i,j+1,true);
//            if (d!=0){
//                return d;
//            }
//        }
//        return result;
//    }
////    46..3
////    ..732
////    .6.4.
////    5.4.3
////    **...
////    ..***
////    .*.*.
////    *.*.*
//    
//}
