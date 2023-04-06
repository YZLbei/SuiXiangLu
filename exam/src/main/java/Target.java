import java.util.HashMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/10/14 16:26
 * @Description:
 */
public class Target {
    static int[] sum(int[]nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp  = nums[i];
            if (map.containsKey(target-temp)){
                return new int[]{i,map.get(target-temp)};
            }
            map.put(temp,i);
        }
        return  new int[0];
    }

    public static void main(String[] args) {
        int []nums = new int[]{2,7,11,15};
        int target = 11;
        int[] res = sum(nums, target);
        if (res.length==0){
            System.out.println("false");
        }
        else {
            System.out.print(res[0] + " " + res[1]);
        }
    }
}
