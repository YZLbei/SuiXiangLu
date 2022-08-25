import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //LinkedList<Integer> array = new LinkedList<>();
        String str = in.next().toString();
        String[] split = str.split(",");
        int []array = new int[split.length];
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (i==0){
                array[i] = Integer.parseInt(String.valueOf(split[i].charAt(1)));
            }
            else if (i==n-1){
                array[i] = Integer.parseInt(String.valueOf(split[i].charAt(0)));
            }
            else {
                array[i] = Integer.parseInt(split[i]);
            }
        }
        int left = 0;
        int right = n-1;
        int res= 0 ;
        while (left<=right){
            int width = right-left;
            Integer a = array[left];
            Integer b = array[right];
            int height = Integer.min(a, b);
            res = Integer.max(res,width*height);
            if (a<=b){
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println(res);
    }
   
}