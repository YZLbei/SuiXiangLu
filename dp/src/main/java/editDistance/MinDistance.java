package editDistance;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/29 16:03
 * @Description:
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示以i-1结尾的和以j-1结尾的编辑距离
        int [][]dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 1; i <=word1.length() ; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <=word2.length() ; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = Integer.min(dp[i-1][j-1],dp[i-1][j]+1);
                }
                else {
                    dp[i][j] = Integer.min(dp[i][j-1],Integer.min(dp[i-1][j],dp[i-1][j-1]))+1;
                }
            }
        }
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                System.out.println(dp[i][j]);   
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
