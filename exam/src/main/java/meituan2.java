import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/24 16:10
 * @Description:
 */
public class meituan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        StringBuilder sb = new StringBuilder(str);
        int res = 0;
        while (sb.indexOf("atc")!=-1){
            int index = sb.indexOf("atc");
            res++;
            sb.replace(index,index+3,"cat");
        }
        System.out.println(res);
    }
    
}
