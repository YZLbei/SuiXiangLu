package difference;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/1 15:15
 * @Description:
 */
public class CorpFlightBookings {
    private int []diff;
    
    public void increment(int[][]bookings,int n){
        for (int k = 0; k < bookings.length; k++) {
            int i = bookings[k][0]-1;
            int j = bookings[k][1]-1;
            int val = bookings[k][2];
            diff[i]+=val;
            if (j+1<n){
                diff[j+1]-=val;
            }
        }
    }
    public int[] result(int n){
        int []res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1]+diff[i];
        }
        return res;
    }
    
        
    public int[] corpFlightBookings(int[][] bookings, int n) {
        diff = new int[n];
        increment(bookings,n);
        return result(n);
    }
}
