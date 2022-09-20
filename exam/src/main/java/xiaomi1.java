import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/20 19:07
 * @Description:
 */
public class xiaomi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int res = dp(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println(res);
    }
    static  int dp(String s1,String s2,int i,int j){
        if (i==-1){
            return j+1;
        }
        if (j==-1){
            return i+1;
        }
        if (s1.charAt(i)==s2.charAt(j)){
            return dp(s1,s2,i-1,j-1);
        }
        int a= dp(s1, s2, i, j - 1) + 1;
        int b = dp(s1, s2, i - 1, j) + 1;
        int c = dp(s1, s2, i - 1, j - 1) + 1;
        int res = Integer.min(a,b);
        res = Integer.min(res,c);
        return res;
    }
}
