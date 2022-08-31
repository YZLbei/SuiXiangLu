import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/31 19:10
 * @Description:
 */
public class duxiaoman1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        result();
//        while (in.hasNext()){
//            result();
//        }
    }
    static public void result(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int []nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        res = 0;
        path = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            backtrack(i,Integer.MAX_VALUE,Integer.MIN_VALUE,k,nums);
        }
        System.out.println(res);
    }
    static int res;
    static  LinkedList<Integer>path;
   static public boolean backtrack(int startIndex,int min,int max,int k,int []nums){
       int n = nums.length;
       if (max/min==k){
           res++;
       }
        if (startIndex==n){
            return true;
        }
        for (int i = startIndex; i < n; i++) {
            path.add(nums[i]);
            int temp_min = min;
            int temp_max = max;
            if (nums[i]<min){
                temp_min = nums[i];
            }
            if (nums[i]>max){
                temp_max = nums[i];
            }
            boolean a = backtrack(i + 1, temp_min, temp_max, k, nums);
            if (a){
                return true;
            }
        }
        return false;
    }
}
