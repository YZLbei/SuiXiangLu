import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/21 19:57
 * @Description:
 */
public class quna1 {
    public int compareVersion (String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int []num1 = new int[3];
        int []num2 = new int[3];
        for (int i = 0; i < str1.length; i++) {
            try {
                num1[i]  = Integer.parseInt(str1[i]);
            }catch (NumberFormatException e){
                break;
            }
        }
        for (int i = 0; i < str2.length; i++) {
            try {
                num2[i]  = Integer.parseInt(str2[i]);
            }catch (NumberFormatException e){
                break;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(num1[i]);
            System.out.println(num2[i]);
        }
        for (int i = 0; i < 3; i++) {
            if (num1[i]>num2[i]){
                return 1;
            }
            else if (num1[i]<num2[i]){
                return -1;
            }
        }
       return 0;
    }

}
