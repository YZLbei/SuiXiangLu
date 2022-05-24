package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for (int i = 0; i <p.length(); i++) {
            char c = p.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left = 0,right =0;
        int valid = 0;
        List<Integer>result = new ArrayList<>();
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            System.out.println("window"+left+","+right);
            while (need.size()==valid){
                if (right-left==p.length()){
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return result;
    }
}
