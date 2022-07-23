package codec;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/23 12:45
 * @Description:
 */
public class Codec {
    StringBuilder res = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sTraverse(root);
        return res.toString();
    }
   
    public void sTraverse(TreeNode root){
        if (root==null){
            res.append("#").append(",");
            return;
        }
        res.append(root.val).append(",");
        sTraverse(root.left);
        sTraverse(root.right);
    }

    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        return dTraverse(res);
    }
    int index;
    public TreeNode dTraverse(String[] data){
        if (data[index].equals("#")){
            return null;
        }
        System.out.println(data[index]);
        TreeNode root  = new TreeNode(Integer.parseInt(data[index]));
        index++;
        root.left = dTraverse(data);
        index++;
        root.right = dTraverse(data);
        return root;
    }
    
}
