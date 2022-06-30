package TwoPointers.LeftRight;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/6/30 10:56
 * @Description:
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = isPalindrome(s, i, i);
            if (s1.length()>result.length()){
                result = s1;
            }
            String s2 = isPalindrome(s, i, i + 1);
            if (s2.length()>result.length()){
                result = s2;
            }
        }
        return result;
    }

    /**
     * 以a和b为中心的最长回文字串
     */
    public String isPalindrome(String s,int a,int b){
        String result = "";
        while (a>=0&&b<=s.length()-1&&s.charAt(a)==s.charAt(b)){
            result =s.substring(a,b+1);
            a--;
            b++;
        }
        return result;
    }
}
