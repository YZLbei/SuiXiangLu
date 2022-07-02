package difference;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/2 11:25
 * @Description:
 */
public class CarPooling {
    int []diff;
    public void increment(int[][] trips){
        for (int[] trip : trips) {
            int val = trip[0];//2
            int i = trip[1];//1
            int j = trip[2];//5
            diff[i]+=val;
            if (j<diff.length){
                diff[j]-=val;
            }
        }
    }
    public boolean result(int capacity){
        int []result = new int[1001];
        result[0] = diff[0];
        if (result[0]>capacity){
            return false;
        }
        for (int i = 1; i < 1001; i++) {
            result[i] = result[i-1]+diff[i];
            if (result[i]>capacity){
                return false;
            }
        }
        return true;
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        diff = new int[1001];
        increment(trips);
//        for (int i = 0; i < 8; i++) {
//            System.out.println(diff[i]);
//        }
        return result(capacity);
    }
}
