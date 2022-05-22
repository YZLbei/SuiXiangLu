public class MinSubArrayLen_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[0];
        int result = Integer.MAX_VALUE;
        while(left<=right) {
            if (sum>=target){
                System.out.println(left+","+right);
                result = Integer.min(result,right-left+1);
                left++;
                sum -=nums[left];
            }
            else{
                right++;
                if (right<nums.length) {
                    sum += nums[right];
                }
            }
        }
        if(result==Integer.MAX_VALUE) {
            return 0;
        }
        else {
            return result;
        }
    }


    /**
     * forÑ­»·°æ
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right <nums.length ; right++) {
            sum+=nums[right];
            while(sum>=target){
                result = Integer.min(result,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
    
}
