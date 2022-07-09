import java.util.Random;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/6 09:33
 * @Description:
 */
public class Random1 {
    int[]preSum;
    java.util.Random random = new java.util.Random();
//    public Solution(int[] w) {
//        int n = w.length;
//        preSum = new int[n+1];
//        preSum[0] = 0;
//        for (int i = 1; i<=n; i++) {
//            preSum[i] = preSum[i-1]+w[i-1];
//        }
//    }
    

    public int pickIndex() {
        int n = preSum.length;
        int target  = random.nextInt(preSum[n-1])+1;
        return left_bound(preSum,target)-1;
    }
    public int left_bound(int []nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (nums[mid]==target){
                right = mid-1;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
