package hard;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/9 09:01
 * @Description:
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        memo = new boolean[n][m];
       return dp(s,p,n-1,m-1);
    }
    boolean [][]memo;
    //[0,i]和[0,j]是否能匹配成功
    public boolean dp(String s,String p, int i ,int j){
        if (i==-1&&j==-1){
            return true;
        }
        if (j<0){
            return false;
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
        
        char a = s.charAt(i);
        char b = p.charAt(j);
        //base case
        if (i==0&&j==0){
            if (a == b || b =='.'|| b =='*'){
                return true;
            }
            else {
                return false;
            }
        }
        if (i==0&&j==1&&p.charAt(1)=='*'&&p.charAt(0)=='.'){
            return true;
        }
        if (memo[i][j]){
            return true;
        }
        boolean res ;
        //没有连着两个*的情况,*也不会是第一个字符
        if (b=='*'){
            char c = p.charAt(j-1);
            //ture
            if (c=='.'){
                boolean q = dp(s, p, i-1, j);
                boolean w = dp(s, p, i - 1, j - 2);
                boolean e = dp(s, p, i, j - 2);
                res = q||w||e;
            }
            //true
            else if (c==a){
                boolean q = dp(s, p, i - 1, j - 2);
                boolean e = dp(s, p, i - 1, j);
                boolean w = dp(s, p, i, j - 2);
                res = q||e||w;
            }
            //可能匹配的是c前的字符
            else{
                res = dp(s,p,i,j-2);
            }
        }
        else if (b=='.'){
            res = dp(s,p,i-1,j-1);
        }
        else {
            if (a!=b){
                return false;
            }
            else {
                res = dp(s,p,i-1,j-1);
            }
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}
