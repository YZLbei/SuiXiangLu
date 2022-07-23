package codec;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/23 12:45
 * @Description:后序遍历构造
 */
public class Codec2 {
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
        sTraverse(root.left);
        sTraverse(root.right);
        res.append(root.val).append(",");
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        index = res.length-1;
        return dTraverse(res);
    }
    int index;
    public TreeNode dTraverse(String[] data){
        if (data[index].equals("#")){
            return null;
        }
        System.out.println(data[index]);
        TreeNode root  = new TreeNode(Integer.parseInt(data[index]));
        index--;
        root.right = dTraverse(data);
        index--;
        root.left = dTraverse(data);
        return root;
    }
    
}
