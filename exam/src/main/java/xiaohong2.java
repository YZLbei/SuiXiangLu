import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/25 17:03
 * @Description:
 */
public class xiaohong2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-->0) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            boolean res = isSeq(s1, s2);
            if (res) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
    static public boolean isSeq(String s1, String s2){
        if (s2.length()>s1.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        while (i<s1.length()&&j<s2.length()){
            if (s2.charAt(j)==s1.charAt(i)){
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        if (j==s2.length()){
            return true;
        }
        return false;
    }
}
