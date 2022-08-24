import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> resolve(int[] candidates, int target) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        backtrack(candidates,target,0);
        return result;
    }
    List<List<Integer>> result;
    List<Integer> path;
    public void backtrack(int[] candidates, int target,int sum){
        if(sum==target){
            if (!result.contains(path)) {
                result.add(new LinkedList<>(path));
            }
            int n = candidates.length;
            for(int i=0;i<n;i++){
                backtrack(candidates,target,sum+candidates[i];
            }
            System.out.println();
        }
    }
}

