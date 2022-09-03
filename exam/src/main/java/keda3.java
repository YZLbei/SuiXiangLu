import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/3 19:48
 * @Description:
 */
public class keda3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []a = new int[6];
        for (int i = 0; i < 6; i++) {
            a[i] = in.nextInt();
        }
        int k = in.nextInt();
        int [][]b = new int[k][6];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 6; j++) {
                b[i][j] = in.nextInt();
            }
        }
        int res = Integer.MAX_VALUE;
        int []result = new int[6];
        for (int i = 0; i < k; i++) {
            boolean a1 = isInverse(b[i][0], b[i][2], b[i][4], b[i][1], b[i][3], b[i][5], a[0], a[1]);
            boolean a2 = isInverse(b[i][0], b[i][2], b[i][4], b[i][1], b[i][3], b[i][5], a[2], a[3]);
            boolean a3 = isInverse(b[i][0], b[i][2], b[i][4], b[i][1], b[i][3], b[i][5], a[4], a[5]);
            
            if (a1&&a2&&a3){
                int squa = Math.abs(b[i][0]*b[i][3]+b[i][2]*b[i][5]+b[i][4]*b[i][1]
                -b[i][0]*b[i][5]-b[i][2]*b[i][1]-b[i][4]*b[i][3])/2;
                if (squa<=res){
                    res = squa;
                    result = b[i];
                }
            }
        }
        if (res==Integer.MAX_VALUE){
            System.out.println("fail");
        }
        else {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i]+" ");
            }
        }
        
    }
    static boolean isInverse(int x1,int x2,int x3,int y1,int y2,int y3,int ax,int ay){
     if (vector(x1,x2,x3,y1,y2,y3)<0)  {
       return   isInverse(x1,x3,x2,y1,y3,y2,ax,ay);
     }
     if (vector(x1,x2,ax,y1,y2,ay)>=0&&vector(x2,x3,ax,y2,y3,ay)>=0&&vector(x3,x1,ax,y3,y1,ay)>=0){
         return true;
     }
     return false;
    }    
    static int vector(int x1,int x2,int x3,int y1,int y2,int y3){
        return (x2-x1)*(y3-y1)-(y2-y1)*(x3-x1);
    }   
    
    
    
}
