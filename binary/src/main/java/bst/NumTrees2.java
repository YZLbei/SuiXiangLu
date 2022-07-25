package bst;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/25 18:13
 * @Description: 递归解法
 */
//需要一个备忘录
public class NumTrees2 {
    int[][]memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return traverse(1,n);
    }
    
    //表示[low,high]组成的BST个数
    public int traverse(int low ,int high){
        if(low>high){
            return 1;
        }
        if (memo[low][high]!=0){
            return memo[low][high];
        }
        int res = 0;
        for (int i = low; i <=high; i++) {
            int left = traverse(low, i-1);
            int right = traverse(i+1, high);
            res+=left*right;
        }
        memo[low][high] = res;
        return res;
    }
}
