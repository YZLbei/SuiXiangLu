import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/28 10:14
 * @Description:
 */
public class ArrayRankTransform {
    public class p{
        int val;
        int i;
        public p(int val) {
            this.val = val;
        }

        public p(int val, int i) {
            this.val = val;
            this.i = i;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length==0){
            return arr;
        }
        int[]res = new int[arr.length];
        p[] power = new p[arr.length];
        for (int j = 0; j < arr.length; j++) {
            //System.out.println(j);
            power[j] = new p(arr[j],j);
        }
        Arrays.sort(power, new Comparator<p>() {
            @Override
            public int compare(p a, p b) {
                if (a == b) {
                    return a.val - b.val;
                }
                else {
                    return a.val - b.val;
                }
            }
        });
//        for (int i = 0; i <power.length ; i++) {
//            System.out.println(power[i].val);
//        }
        res[power[0].i] = 1;
        int count  = 1;
        for (int i = 1; i < power.length; i++) {
            if (power[i].val==power[i-1].val){
                res[power[i].i]=count;
            }
            else {
                res[power[i].i] = ++count;
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayRankTransform a =new ArrayRankTransform();
        a.arrayRankTransform(new int[]{2,3,1,4});
        
    }
}
