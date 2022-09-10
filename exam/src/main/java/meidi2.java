import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
 
public class meidi2 {
    public int maxPointsNum (Point[] points) {
       int n = points.length;
       if (n<=2){
           return n;
       }
       int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Float,Integer> map = new HashMap<Float, Integer>();
            int vertical = 0;
            int coincide = 0;
            for (int j = 0; j < n; j++) {
                if (points[i].x==points[j].x){
//                    if (points[i].y==points[j].y){
//                        coincide++;
//                    }
//                    else {
//                        vertical++;
//                    }
                    vertical++;
                }
                else {
                    int a = points[i].y-points[j].y;
                    int b = points[i].x - points[j].x;
                    float slope = (float)a/(float)b;

//                    if (map.get(slope)==null){
//                        map.put(slope,1);
//                    }
//                    else {
//                        map.put(slope,map.get(slope)+1);
//                    }
                    map.put(slope,map.getOrDefault(slope,1)+1);
                    //map.merge(slope, 1, Integer::sum);
                }
            }
            res = Integer.max(res,vertical);
            //int temp = vertical;
            for (Map.Entry<Float, Integer> f : map.entrySet()) {
                res = Integer.max(res,f.getValue());
            }
            //res = Integer.max(temp+coincide,res);
        }
        return res;
    }
}
