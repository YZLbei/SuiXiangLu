package slidingwindow;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0,right = 0;
        int result = 0;
        while(right<s.length()){
            char c  = s.charAt(right);
            right++;
            
            boolean updateLeft =false;
            if (!window.containsKey(c)||window.get(c)==0){
                result = Integer.max(result,right-left);
                //window.put(c,1);
            }
            else {
                updateLeft = true;
               // window.put(c,2);
            }
            window.put(c,window.get(c)+1);
            System.out.println("window:"+left+","+right);
            while(updateLeft){
                char d = s.charAt(left);
                left++;
                if (window.get(d)==2){
                    updateLeft = false;
//                    window.put(d,1);
                }
                window.put(d,window.get(d)-1);
            }
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0,right = 0;
        int result = 0;
        while(right<s.length()){
            char c  = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c,0)+1);
            while(window.get(c)>1){
                char d = s.charAt(left);
                left++;
                window.put(d,window.get(d)-1);
            }
            result = Integer.max(result,right-left);
        }
        return  result;
    }
}
