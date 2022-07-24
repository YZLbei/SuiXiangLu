package post;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/23 21:21
 * @Description:
 */
public class FindDuplicateSubtrees {
    HashMap<String, Integer>map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        System.out.println(map.size());
        return res;
    }
    public String serialize(TreeNode root){
        if (root==null){
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        String myself =left+","+right+","+root.val;
        Integer i = map.getOrDefault(myself, 0);
        if (i==1){
            res.add(root);
        }
        map.put(myself,i+1);
        return myself;
    }
}
