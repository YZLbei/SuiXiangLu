/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/7 19:28
 * @Description:
 */
public class tongcheng {
    public static String longestPrefix (String s) {
        // write code here
        int left  =0;
        int right = s.length()-1;
        StringBuilder res = new StringBuilder();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        while (left<=s.length()-2){
            a.append(s.charAt(left));
            
            
            b.insert(0,s.charAt(right));
            if (a.toString().equals(b.toString())){
                res = new StringBuilder(a);
            }
            left++;
            right--;
            //System.out.println(res);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("ababab"));
    }
}
