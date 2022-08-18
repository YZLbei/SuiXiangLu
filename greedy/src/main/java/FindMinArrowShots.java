import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/18 08:14
 * @Description:用最少数量箭射爆气球
 * 相当于让重叠的区间尽可能多
 */
public class FindMinArrowShots {
    //按照左边界排序
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparing(o->o[0]));
//        for (int i = 0; i < points.length; i++) {
//            System.out.println(points[i][0]+"   "+points[i][1]);
//        }
        int res = 1;
        long right = points[0][1] ;
        //System.out.println(right);
        for (int i = 1; i < n; i++) {
            //有重叠要更新重叠边界，为最小边界
            if (points[i][0]<=right){
                right = Long.min(right,points[i][1]);
            }
            if (points[i][0]>right){
                res+=1;
                right = points[i][1]; 
            }
        }
        return res;
    }
}
