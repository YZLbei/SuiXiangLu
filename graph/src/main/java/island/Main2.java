package island;

import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/30 20:31
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String str1 = s1.replaceAll(" +"," ");
        str1  = str1.trim();
        String str2 = s2.replaceAll(" +"," ");
        str2  = str2.trim();
        String[] chars1= str1.split(" ");
        String[] chars2= str2.split(" ");
        int m = chars1.length;
        System.out.println(m);
        int n = chars2.length;
        int res = dp(chars2, n - 1, chars1, m - 1);
        System.out.println(res);
        System.out.println(m-res);
    }
    static int dp(String[] s1,int i,String[] s2,int j){
        if (i==-1){
            return j+1;
        }
        if(j==-1){
            return i+1;
        }
        if (s1[i].equals(s2[j])){
            return dp(s1,i-1,s2,j-1);
        }
        int a = dp(s1, i, s2, j - 1) + 2;
        int b = dp(s1, i - 1, s2, j) + 1;
        
        int c = dp(s1, i - 1, s2, j - 1)+1;
        
        return Integer.min(a,Integer.min(b,c));
    }
}
