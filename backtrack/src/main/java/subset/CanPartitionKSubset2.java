package subset;

import java.util.HashMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/22 17:27
 * @Description:
 */
public class CanPartitionKSubset2 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除一些基本情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int v : nums) sum += v;
        if (sum % k != 0) return false;

        int used = 0; // 使用位图技巧
        int target = sum / k;
        // k 号桶初始什么都没装，从 nums[0] 开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();

    boolean backtrack(int k, int bucket,
                      int[] nums, int start, int used, int target) {
        // base case
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            return true;
        }
        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            // 缓存结果
            memo.put(used, res);
            System.out.println(memo.size());
            return res;
        }
        System.out.println(memo.get(used));
        if (memo.containsKey(used)) {
            System.out.println(111);
            // 避免冗余计算
            return memo.get(used);
        }

        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (((used >> i) & 1) == 1) { // 判断第 i 位是否是 1
                // nums[i] 已经被装入别的桶中
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            used |= 1 << i; // 将第 i 位置为 1
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            used ^= 1 << i; // 使用异或运算将第 i 位恢复 0
            bucket -= nums[i];
        }

        return false;
    }
    public static void main(String[] args) {
        CanPartitionKSubset2 c = new CanPartitionKSubset2();
        int []num= {605,454,322,218,8,19,651,2220,175,710,2666,350,252,2264,327,1843};
        boolean b = c.canPartitionKSubsets(num, 4);
        System.out.println(b);
    }
    
}

