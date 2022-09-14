import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/14 19:13
 * @Description:
 */
public class xiecheng1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int resa =  0;
            int resb =  0;
            int numa = 0;
            int numb = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int a = in.nextInt();
                    if (a==1){
                        numa++;
                        if (i==0&&j==0){
                            resa+=1;
                        }
                        else if (i==0&&j==1){
                            resa+=30;
                        }
                        else if (i==1&&j==0){
                            resa+=50;
                        }
                        else {
                            resa+=100;
                        }
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int b = in.nextInt();
                    if (b == 1) {
                        numb++;
                        if (i == 0 && j == 0) {
                            resb += 1;
                        } else if (i == 0 && j == 1) {
                            resb += 30;
                        } else if (i == 1 && j == 0) {
                            resb += 50;
                        } else {
                            resb += 100;
                        }
                    }
                }
            }
            if (numa!=numb){
                System.out.println(-1);
            }
            else {
                if (resa==resb){
                    System.out.println(0);
                }
                else {
                    int max = 0 ;
                    int min = 0;
                    if (resa>resb){
                        max = resa;
                        min = resb;
                    }
                    else {
                        max = resb;
                        min = resa;
                    }
                    int k = max - min;
                    if(k==29||k==49||k==70||k==50){
                        System.out.println(1);
                    }
                    else {
                        System.out.println(2);
                    }
                }
                
            }
            
            
        
        }
    }
}
