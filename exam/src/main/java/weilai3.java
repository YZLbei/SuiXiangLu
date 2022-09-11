import java.util.Scanner;


/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/11 21:05
 * @Description:
 */
public class weilai3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            int n = in.nextInt();
            int max = Integer.MIN_VALUE;
            int index = 0;
            for (int i = 0; i <=str.length() - n; i++) {
                int count = 0 ;
                for (int j = i; j < i + n; j++) {
                    if (str.charAt(j)=='G'||str.charAt(j)=='C'){
                        count++;
                    }
                    if (count>max){
                        index = i;
                        max = count;
                    }
                }
            }
            System.out.println(str.substring(index,index+n));
        }
    }
}
