import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/18 08:00
 * @Description:无重叠区间，贪心解法
 */
public class EraseOverlapIntervals {
    //首先要排序，按照右区间排序，右区间相同左区间小的在前
    //如果第i+1个区间
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if (a[1]==b[1]){
                return a[0]-b[0];
            }
            else {
                return a[1]-b[1];
            }
        });
        int res = 0;
        int right = intervals[0][1];
        System.out.println(right);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            //要删除，右边界不变
            if (intervals[i][0]<right){
                res++;
            }
            else {
                right = intervals[i][1];
            }
        }
        return res;
    }
}
