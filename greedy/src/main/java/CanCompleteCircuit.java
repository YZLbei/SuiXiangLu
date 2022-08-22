/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/22 11:38
 * @Description:
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int n = cost.length;
        int totalSum = 0;
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            int temp = gas[i] - cost[i];
            totalSum +=temp;
            curSum += temp;
            if (curSum<0){
                res = i;
                curSum = 0;
            }
        }
        if (totalSum<0){
            return -1;
        }
        else {
            return res;
        }
    }
}
