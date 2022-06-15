package slidingwindow;

import java.util.HashMap;

public class MinWindow2 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character,Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        
        int vaild = need.keySet().size();
        String result = null;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            
            window.put(c,window.getOrDefault(c,0)+1);
            if (window.get(c).equals(need.get(c))){
                vaild--;
            }
            while (vaild==0){
                if (result==null){
                    result = s.substring(left, right);
                }
                else if (right-left<result.length()){
                    result = s.substring(left, right);
                }
                char d = s.charAt(left);
                left++;
                if (window.get(d).equals(need.get(d))){
                    vaild++;
                }
                window.put(d,window.get(d)-1);
            }
            
        }
        if (result==null){
            return "";
        }
        else {
            return result;
        }
    }

    public static void main(String[] args) {
        MinWindow2 m = new MinWindow2();
        String s = m.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}