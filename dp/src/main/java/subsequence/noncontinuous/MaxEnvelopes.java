package subsequence.noncontinuous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/27 17:10
 * @Description:
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==1){
            return 1;
        }
        //先对envelopes按照宽度排序，
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0]==b[0]){
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        });
        int []dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int result = 0;
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0]>envelopes[j][0]&&
                    envelopes[i][1]>envelopes[j][1]) {
                    dp[i] = Integer.max(dp[i],dp[j]+1);
                }
                if (dp[i]>result){
                    result = dp[i];
                }
            }
        }
        return result;
    }
}
