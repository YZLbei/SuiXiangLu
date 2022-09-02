import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/2 10:30
 * @Description:
 */
public class gaotu3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        if (s1[0].equals("0")||s1[1].equals("0")){
            System.out.println(0);
            System.exit(0);
        }
        int l1=s1[0].length();
        int l2 =s1[1].length();
        int []num = new int[l1+l2];
        for (int i = l1-1; i >=0; i--) {
            int x = s1[0].charAt(i) -'0';
            for (int j = l2-1; j >=0; j--) {
                int y = s1[1].charAt(j)-'0';
                num[i+j+1]+=x*y;
            }
        }
        for (int i = l1+l2-1; i >0; i--) {
            num[i-1]+=num[i]/10;
            num[i]%=10;
        }
        int index = num[0]==0?1:0;
        StringBuilder res = new StringBuilder();
        while (index<l1+l2){
            res.append(num[index]);
            index++;
        }
        System.out.println(res.toString());

    }
}
