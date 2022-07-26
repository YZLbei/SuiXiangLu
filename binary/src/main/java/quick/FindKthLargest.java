package quick;

import java.util.PriorityQueue;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/26 19:49
 * @Description:数组中第k个最大的元素（二叉堆实现）
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if (q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }
}
