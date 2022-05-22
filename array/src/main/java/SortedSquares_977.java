public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0 ;
        int right = nums.length - 1;
        int []result = new int[nums.length];
        int index = nums.length-1;
        while (left<=right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            if (leftSquare<=rightSquare){
                result[index] = rightSquare;
                right--;
                index--;
            }
            else{
                result[index] = leftSquare;
                left++;
                index--;
            }
        }
        return result;
    }
}
