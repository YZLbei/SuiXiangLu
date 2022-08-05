/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/4 09:45
 * @Description:回溯法，但是超时
 */
public class CalculateMinimumHP2 {
    public int calculateMinimumHP(int[][] dungeon) {
        traverse(dungeon,0,0,1,1);
        return res;
    }
    //cur表示当前血量
    //表示需要的初始血量
    int res = Integer.MAX_VALUE;
    public void traverse(int[][] dungeon,int i,int j,int cur,int start){
        int n = dungeon.length;
        int m = dungeon[0].length;
        if (i==n-1&&j==m-1){
            if (cur+dungeon[i][j]>=1) {
                res = Integer.min(start,res);
            }
            else {
                res = Integer.min(res,start+1-cur-dungeon[i][j]);
            }
            return;
        }
        
        int temp = cur+dungeon[i][j];
        if (temp>=1) {
            cur = temp;
        }
        else {
            start+=1-cur-dungeon[i][j];
            cur = 1;
        }
        
        if (i==n-1){
            traverse(dungeon,i,j+1,cur,start);
        }
        else if (j==m-1){
            traverse(dungeon,i+1,j,cur,start);
        }
        else {
            traverse(dungeon,i+1,j,cur,start);
            traverse(dungeon,i,j+1,cur,start);
        }
        
    }
}
