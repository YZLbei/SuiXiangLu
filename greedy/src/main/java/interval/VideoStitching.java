package interval;

import java.util.Arrays;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/19 16:56
 * @Description:按照左边界排序，然后找重叠的且右边界最大的视频
 */
public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        if (n==1){
            if (clips[0][0]==0&&clips[0][1]>=time){
                return 1;
            }
            else {
                return -1;
            }
        }
        Arrays.sort(clips,(a,b)->{
            if (a[0]==b[0]){
                //左边界相同时，选右边界最大的
                return b[1]-a[1];
            }
            else {
                return a[0]-b[0];
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(clips[i][0]+"   "+clips[i][1]);
        }
        //clips[0]就是第一个视频
        if (clips[0][0]!=0){
            return -1;
        }
        int res = 1;
        int lastEdge = clips[0][1];
        int curEdge = clips[0][1];
        for (int i = 1; i < n; i++) {
            if (curEdge>=time){
                return res;
            }
            //找到和当前有重叠且右边界最大的
            int j = i;
            //curEdge = lastEdge;
            while (j<=n-1) {
                //有重叠
                if (clips[j][0] <= lastEdge) {
                    curEdge = Integer.max(curEdge,clips[j][1]);
                    j++;
                }
                else if(clips[j][0]>curEdge){
                    return -1;
                }
                else {
                    break;
                }
            }
            i=j-1;
            res++;
            System.out.println(curEdge);
            lastEdge = curEdge;
        }
        return -1;
    }
}
