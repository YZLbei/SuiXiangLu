package dichotomy.realproblem;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/9 22:29
 * @Description:
 */
public class ShipWithinDays {
    public long f(int[]weights ,int x){
        long days = 0;
        int sum = 0;
        //1,2,3,4,5,6,7,8,9,10
        for (int i = 0; i < weights.length; i++) {
            sum+=weights[i];
            if (sum==x){
                //System.out.println(sum);
                days++;
                sum = 0;
            }
            else if(sum>x){
                //System.out.println(sum);
                days++;
                sum=0;
                i--;
            }
        }
        if (sum!=0){
            days++;
        }
        System.out.println(days);
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        //System.out.println(left);
        int right = 25000000;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (f(weights,mid)<=days){
                right = mid - 1;
            }
            else {
                left = mid +1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        ShipWithinDays s = new ShipWithinDays();
        s.f(new int[]{1,2,3,4,5,6,7,8,9,10},14);
    }
}
