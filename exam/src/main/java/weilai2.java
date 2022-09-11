import java.util.HashSet;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/11 20:30
 * @Description:
 */
public class weilai2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String str1 = in.nextLine();
        String s1 ="aeiou";
        char[][] chars= new char[26][2];
        StringBuilder res = new StringBuilder();
        String str = "bcdfghjklmnpqrstvwxyz";
        for (int i = 0; i < str.length(); i++) {
            if (s1.contains(String.valueOf(str.charAt(i)))){
                continue;
            }
            else {
                int l1 = 0;
                int l2 = 0;
                char a = str.charAt(i);
                while (!s1.contains(String.valueOf(a))){
                    l1++;
                    a--;
                }
                a = str.charAt(i);
                while (!s1.contains(String.valueOf(a))){
                    l2++;
                    a++;
                }
                a = str.charAt(i);
                if (l1<=l2){
                    char b = (char) (a - l1);
                    chars[str.charAt(i)-'a'][0] = b;
                }
                else {
                    char b = (char) (a + l2);
                    chars[str.charAt(i)-'a'][0] = b;
                }
                a = str.charAt(i);
                if (a=='z'){
                    chars[str.charAt(i)-'a'][1] = a;
                }
                else {
                    a++;
                    while (s1.contains(String.valueOf(a))) {
                        a++;
                    }
                    chars[str.charAt(i) - 'a'][1] = a;
                }
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            if (s1.contains(String.valueOf(str1.charAt(i)))){
                res.append(str1.charAt(i));
            }
            else {
                res.append(str1.charAt(i));
                res.append(chars[str1.charAt(i)-'a'][0]);
                res.append(chars[str1.charAt(i)-'a'][1]);
            }
        }
        System.out.println(res);
        
    }
}
