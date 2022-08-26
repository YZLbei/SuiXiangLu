package chessboard;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/20 10:08
 * @Description:
 */
public class SolveNQueens {
    List<List<String>> result = new LinkedList<>();
    char [][]path;
    public List<List<String>> solveNQueens(int n) {
        path = new char[n][n];
        backtrack(n,0);
        return result;
    }
    //i表示在第几行放置皇后
    public void backtrack(int n,int i){
        if (i==n){
            //将path转化为List<String>
            result.add(ToString(n));
            return;
        }
        //i.j表示放置皇后的位置
        for (int j = 0; j < n; j++) {
            if (put(i,j,n)){
                path[i][j] ='Q';
                backtrack(n,i+1);
                path[i][j] = '.';
            }
        }
    }
    //根据已经放置的皇后判断i,j是否可以放置
    public boolean put(int i,int j,int n){
        //判断行
        for (int k = 0; k < j; k++) {
            if (path[i][k]=='Q'){
                return false;
            }
        }
        //判断列
        for (int k = 0; k < i; k++) {
            if (path[k][j]=='Q'){
                return false;
            }
        }
        //判断左斜线
        for (int k = i,o = j; k>=0&&o>=0 ; k--,o--) {
            if (path[k][o]=='Q'){
                return false;
            }
        }
        //右斜线
        for (int k = i,o = j; k>=0&&o<=n-1 ; k--,o++) {
            if (path[k][o]=='Q'){
                return false;
            }
        }
        return true;
    }
    //将path转化为List
    public List<String> ToString(int n){
        List<String>res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (path[i][j]=='Q'){
                    s.append('Q');
                }
                else {
                    s.append('.');
                }
            }
            res.add(s.toString());
        }
        return res;
    }
}
