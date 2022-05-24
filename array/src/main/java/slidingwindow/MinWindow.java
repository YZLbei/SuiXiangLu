package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>need = new HashMap<>();
        HashMap<Character,Integer>window = new HashMap<>();
        int valid = 0;
        //左闭右开
        int left = 0,right =0;
        //记录最小覆盖字串的起始索引和长度
        int start =0,len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c, 0)+1);
        }
        while(right<s.length()){
            //c是将移入窗口的字符
            char c = s.charAt(right);
            //增大窗口
            right++;
            
            //进行一系列的数据更新
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            //System.out.println("window:"+left+","+right);
            
            //判断左侧窗口是否要收缩
            while (valid==need.size()){
                if (right-left<len){
                    start = left;
                    len  = right-left;
                }
                //d是将要移出的字符
                char d = s.charAt(left);
                //缩小窗口
                left++;

                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
                
            }
        }
        System.out.println(start+","+len);
       return len ==Integer.MAX_VALUE? "":s.substring(start,len+start);
        
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        minWindow.minWindow("ADOBECODEBANC","ABC");
    }
}
