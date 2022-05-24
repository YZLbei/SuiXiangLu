package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer>need = new HashMap<>();
        HashMap<Character,Integer>window = new HashMap<>();
        int valid = 0;
        //����ҿ�
        int left = 0,right =0;
        //��¼��С�����ִ�����ʼ�����ͳ���
        int start =0,len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c, 0)+1);
        }
        while(right<s.length()){
            //c�ǽ����봰�ڵ��ַ�
            char c = s.charAt(right);
            //���󴰿�
            right++;
            
            //����һϵ�е����ݸ���
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            //System.out.println("window:"+left+","+right);
            
            //�ж���ര���Ƿ�Ҫ����
            while (valid==need.size()){
                if (right-left<len){
                    start = left;
                    len  = right-left;
                }
                //d�ǽ�Ҫ�Ƴ����ַ�
                char d = s.charAt(left);
                //��С����
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
