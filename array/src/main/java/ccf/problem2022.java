package ccf;

import java.util.Scanner;

public class problem2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int []bianliang = new int[n];
        int result = 0;
        int x;
        int y;
        for (int i = 0; i < k; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (y==0){
                
            }
            else if (bianliang[y-1]==0){
                
                result++;
            }
            bianliang[x-1] = 1;
        }
        System.out.println(result);
    }
}
