/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/14 10:26
 * @Description:
 */
public class genhao2 {
    public static void main(String[] args) {
        double t = 0.000001;
        double l  =1.4;
        double h = 1.5;
        double mid= 0 ;
        while (h-l>t){
            mid = (h+l)/2;
            if (mid*mid>2){
                h =  mid;
            }
            else {
                l = mid;
            }
        }
        System.out.println(mid);
    }
}
