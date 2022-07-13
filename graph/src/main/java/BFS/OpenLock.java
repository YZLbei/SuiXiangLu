package BFS;

import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/13 15:26
 * @Description:
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String>q = new LinkedList<>();
        Set<String>visited = new HashSet<>();
        Set<String> dead= new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        
        q.add("0000");
        visited.add("0000");
        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)){
                    return res;
                }
                if (dead.contains(cur)){
                    continue;
                }
                char[] chars = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char temp = chars[j];
                    if (chars[j]== '9') {
                       chars[j]='0';
                    }
                    else {
                        chars[j]+=1;
                    }
                    String s = new String(chars);
                    if (!visited.contains(s)){
                        System.out.println(s);
                        q.offer(s);
                        visited.add(s);
                    }
                    
                    chars[j] = temp;
                    if (chars[j] == '0') {
                        chars[j]='9';
                    }
                    else {
                        chars[j]--;
                    }
                    String s1 = new String(chars);
                    if (!visited.contains(s1)){
                        System.out.println(s1);
                        q.offer(s1);
                        visited.add(s1);
                    }
                    chars[j] = temp;
                    
                }
            }
            res++;
        }
        System.out.println(res);
        return -1;
    }
    

    public static void main(String[] args) {
        OpenLock o = new OpenLock();
        o.openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
    }

}
