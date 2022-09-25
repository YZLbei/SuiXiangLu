import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/25 19:29
 * @Description:
 */
public class zijie3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0) {
            long x = in.nextLong();
            long y = in.nextLong();
            long target = Math.abs(x-y);
            long res= dis(target);
            System.out.println(res*2);
        }
    }
  static   public long dis(long target){
      long l = 0;
      if (target%2==0){
          l = target/2;
      }
      else {
          l = target/2+1;
      }
      double res = (Math.pow(1+8*l,0.5)-1)/2;
     // System.out.println(res);
      if (Math.round(res)==res){
          return (long) res;
      }
      else {
          return (long) (res+1);
      }
  }
    
    
}
