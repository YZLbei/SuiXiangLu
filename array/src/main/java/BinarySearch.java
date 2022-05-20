public class BinarySearch {
    /**
     * 左闭右闭
     * 一定要注意区间
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = (left+right)/2;
        while (left<=right){
            if (nums[middle]==target){
                return middle;
            }
            else if (nums[middle]<target){
                left = middle+1;
                middle =(left+right)/2;
            }
            else{
                right = middle-1;
                middle =(left+right)/2;
            }
        }
        return -1;
    }

    /**
     * 左闭右开
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
    
}
