package classic;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/5 10:21
 * @Description:
 */
public class FindRotateSteps {
    //0表示向左
    //1表示向右
    
    
    int [][]dp;
    int []left = new int[2];
    int []right = new int[2];
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        dp = new int[m][2];
        int count = 1 ;
        //left表示向左旋转最终的位置
        //初始化
        if (ring.charAt(0)==key.charAt(0)){
            dp[0][0] = 1;
            dp[0][1] = 1;
        }
        else {
            for (int i = n - 1; i > 0; i--) {
                if (ring.charAt(i) == key.charAt(0)) {
                    left[0] = i;
                    left[1] = i;
                    dp[0][0] = count+ 1;
                    break;
                } else {
                    count++;
                }
            }
            count = 1;
            for (int i = 1; i < n; i++) {
                if (ring.charAt(i) == key.charAt(0)) {
                    right[0] = i;
                    right[1] = i;
                    dp[0][1] = count+ 1;
                    break;
                } else {
                    count++;
                }
            }
        }

        //左左left[0]
        //右左left[1]——上一个是向右本次向左
        //左右left[0]
        //右右left[0]
        for (int i = 1; i < m; i++) {
            int left1 = left(ring, left[0], key.charAt(i),0);
            int left2 = left(ring, left[1], key.charAt(i),1);
            int right1 = right(ring, right[0], key.charAt(i),0);
            int right2 = right(ring, right[1], key.charAt(i),1);
            int a = left1 + dp[i - 1][0];
            int b = left2 + dp[i - 1][1];
            int c = right1 + dp[i - 1][0];
            int d = right2 + dp[i - 1][1];
            if (a<=b){
                dp[i][0] = a;
            }
            else {
                dp[i][0] = b;
            }
            if (c<=d){
                dp[i][1] = c;
            }
            else {
                dp[i][1] = d;
            }
            System.out.println("dadas"+left[0]+"   "+left[1]+"   "+right[0]+"   "+right[1]);
        }
        for (int i = 0; i < m; i++) {
            System.out.println(dp[i][0]+"   "+dp[i][1]);
        } 
        return Integer.min(dp[m-1][0],dp[m-1][1]);
        
    }
    
    //向左旋转
    public int left(String ring,int start,char a,int i){
        int count = 0;
        for (int j = start; j >=0; j--) {
            if (ring.charAt(j) == a) {
                //dp[0][0] = count+ 1;
                if (i==0){
                    left[0] = j;
                }
                else {
                    left[1] = j;
                }
                return count+1;
            } else {
                if (j==0){
                    j = ring.length();;
                }
                count++;
            }
        }
        return Integer.MAX_VALUE;
    }
    //向右旋转
    public int right(String ring,int start,char a,int i){
        int count = 0;
        int n = ring.length();
        for (int j = start; j <n; j++) {
            if (ring.charAt(j) == a) {
                //dp[0][0] = count+ 1;
                if (i==0){
                    right[0] = j;
                }
                else {
                    right[1] = j;
                }
                return count+1;
            } else {
                if (j==n-1){
                    j = -1;
                }
                count++;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        FindRotateSteps f = new FindRotateSteps();
        f.findRotateSteps("ababcab","acbaacba"  );
    }
}
