import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 16:02
 * @Description:
 */
public class meituan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while (t-->0){
            String str = in.nextLine();
            //System.out.println(str);
            System.out.println(maxNum(str));
        }
    }
    static public int maxNum(String str){
        int []word = new int[26];
        for (int i = 0; i < str.length(); i++) {
            word[str.charAt(i)-'a']+=1;
        }
        int res = 0;
        boolean flag =false;
        for (int i = 0; i < 26; i++) {
            if (word[i]%2==0){
                res+=word[i];
            }
            else {
                flag = true;
                res+=word[i]-1;
            }
        }
        if (flag){
            res+=1;
        }
        return res;
    }
}
