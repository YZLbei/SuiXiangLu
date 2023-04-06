import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/10/14 15:19
 * @Description:
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:输入: "()"        输出: true
 * 示例 2:输入: "()[]{}"   输出: true
 * 示例 3:输入: "(]"        输出: false
 * 示例 4:输入: "([)]"     输出: false
 * 示例 5:输入: "{[]}"     输出: true
 * 于祯龙
 */
public class huawei {
    static public boolean isValid(String s){
        if (s.isEmpty()){
            return  true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a=='('){
                stack.push(')');
            }
            else if (a=='['){
                stack.push(']');
            }
            else if (a=='{'){
                stack.push('}');
            }
            else if (stack.isEmpty()||a!=stack.pop()){
                return  false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String s = in.nextLine();
            boolean res = isValid(s);
            System.out.println(res);
        }
        
    }
}
