package difference;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/1 12:03
 * @Description:
 */
public class Difference {
    //差分数组
    private int[]diff;
    //初始化差分数组
    public Difference(int []nums){
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i-1];
        }
    }
    
    //给区间[i,j]增加val
    public void increment(int i,int j,int val){
        diff[i] +=val;
        if (j+1<diff.length){
            diff[j+1]-=val;
        }
    }
    
    //返回结果数组
    public int[]result(){
        int []res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i-1]+diff[i];
        }
        return res;
    }
}
