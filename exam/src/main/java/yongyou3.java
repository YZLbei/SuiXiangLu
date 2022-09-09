import java.util.ArrayList;
import java.util.Stack;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/9 20:15
 * @Description:
 */
public class yongyou3 {
    public int[] findBuilding (int[] heights) {
        Stack<Integer>stack1  = new Stack<>();
        Stack<Integer>stack2 = new Stack<>();
        ArrayList<Integer> count1 = new ArrayList<>();
        ArrayList<Integer> count2 = new ArrayList<>();
        for (int i = 0,j=heights.length-1; i < heights.length&&j>=0; i++,j--) {
            count1.add(stack1.size());
            count2.add(0,stack2.size());
            while (!stack1.isEmpty()&&stack1.peek()<=heights[i]){
                stack1.pop();
            }
            while (!stack2.isEmpty()&&stack2.peek()<=heights[j]){
                stack2.pop();
            }
            stack1.push(heights[i]);
            stack2.push(heights[j]);
        }
        int []res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            res[i] = count1.get(i)+count2.get(i)+1;
        }
        return res;
    }
}
