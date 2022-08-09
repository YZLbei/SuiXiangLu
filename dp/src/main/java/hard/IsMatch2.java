package hard;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/9 09:01
 * @Description:改造
 */
public class IsMatch2 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        memo = new boolean[n][m];
       return dp(s,p,n-1,m-1);
    }
    boolean [][]memo;
    //[0,i]和[0,j]是否能匹配成功
    public boolean dp(String s,String p, int i ,int j){
        if (j==-1){
            return i==-1;
        }
        if (i<0){
            int temp = j;
            while (temp>=0){
                char c = p.charAt(temp);
                if (c=='*'){
                    temp-=2;
                }
                else {
                    
                    return false;
                }
            }
            return true;
        }
        if (memo[i][j]){
            return true;
        }
        char a = s.charAt(i);
        char b = p.charAt(j);
        boolean res ;
        //没有连着两个*的情况,*也不会是第一个字符
        if (b=='*'){
            char c = p.charAt(j-1);
            //ture
            //只需要0次和多次，1次涵盖在这里
            if (c=='.'||c==a){
                boolean q = dp(s, p, i-1, j);
                boolean e = dp(s, p, i, j - 2);
                res = q||e;
            }
            //可能匹配的是c前的字符
            else{
                res = dp(s,p,i,j-2);
            }
        }
        else if (b=='.'||a==b){
            res = dp(s,p,i-1,j-1);
        }
        else { 
            return false;
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}
