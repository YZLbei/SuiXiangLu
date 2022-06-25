public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //result就表示最后的长度
        int result = 0;
        //当前遍历到的位置
        int index = 0;
        for(int i=0;i<nums.length;i++){
            for (int j = index; j < nums.length; j++){
                if (nums[j]!=val){
                    result++;
                    nums[i] = nums[j];
                    index = j+1;
                    break;
                }
            }
            if (index==nums.length){
                break;
            }
        }
        return result;
    }


    /**
     * 双指针解法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(nums[slow]!=val){
                fast++;
                slow++;
            }
            else {
                if(nums[fast]!=val){
                    nums[slow] = nums[fast];
                    nums[fast] = val;
                    slow++;
                    fast++;
                }
                else{
                    fast++;
                }
            }
        }
        return slow;
    }


    /**
     * 更好的双指针思路
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        int slow = 0;
        int fast= 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow++] =nums[fast];
            }
        }
        return slow;
    }



    public int removeElement4(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    
}
