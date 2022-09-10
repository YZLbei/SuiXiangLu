import java.util.ArrayList;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/10 21:00
 * @Description:
 */
public class meidi1 {
    public ArrayList<ArrayList<Integer>> generate (int numRows) {
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        if (numRows==0){
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer>cur  = new ArrayList<>();
            for (int j = 0; j <=i; j++) {
                if((j==0)||(j==i)){
                    cur.add(1);
                }
                else {
                    ArrayList<Integer>pre = res.get(i-1);
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}
