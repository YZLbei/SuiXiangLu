package slidingwindow;

import java.util.HashMap;

public class CheckInclusion_567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        int left =0,right = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int valid = 0;
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            System.out.println("window"+left+","+right);
            while(valid==need.size()){
                if (right-left==s1.length()){
                    return true;
                }
                char d= s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
            
        }
        return false;
    }
}
