package reverse;

import java.util.List;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/22 11:37
 * @Description:
 */
public class IsPalindrome {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
       return traverse(left);
    }
    public boolean traverse(ListNode right){
        if (right==null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res&&(left.val==right.val);
        left = left.next;
        return res;
    }

    //寻找回文串
    public String palindrome(String s,int left,int right){
        //防止索引越界
        while (left>=0&&right<s.length()&&
                s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        // 返回以 s[left] 和 s[right] 为中心的最长回文串
        return s.substring(left+1,right);
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1 ;
        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
