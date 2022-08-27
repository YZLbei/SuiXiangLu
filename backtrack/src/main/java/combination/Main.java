package combination;

import javafx.scene.transform.Scale;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/8/26 19:38
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = Integer.parseInt(in.nextLine());
        List<String>[] word = new List[M];
        List<String>[]stop = new List[M];
        int []word_num= new int[M];
        int []stop_num = new int[M];
        for (int i = 0; i < M; i++) {
            String word_temp = in.nextLine();
            String[] s1 = word_temp.split(" ");
            word[i] = new LinkedList<>();
            word_num[i] = Integer.parseInt(s1[0]);
            for (int j = 0; j < word_num[i]; j++) {
                word[i].add(s1[j+1].toLowerCase());
            }
            Collections.sort(word[i]);
            stop[i] = new LinkedList<>();
            String stop_temp = in.nextLine();
            String[] s2 = stop_temp.split(" ");
            stop_num[i] = Integer.parseInt(s2[0]);
            for (int j = 0; j < stop_num[i]; j++) {
                stop[i].add(s2[j+1].toLowerCase());
            }
        }
        for (int i = 0; i < M; i++) {
            int res = 0;
            int temp= 0 ;
            boolean x =false;
            for (int j = 0; j < word_num[i]; j++) {
                for (int k = 0; k < stop_num[i]; k++) {
                    for (int l = 0; l < stop[i].size(); l++) {
                        if (!bijiao(word[i].get(j),stop[i].get(k))){
                            x = true;
                            break;
                        }
                    }
                    if (j==0){
                        if (!x){
                            temp++;
                        }
                    }
                    else {
                        if (!x) {
                            if (word[i].get(j).equals(word[i].get(j - 1))) {
                                temp++;
                            } else {
                                res = Integer.max(res, temp);
                                temp = 0;
                            }

                        }
                        }
                    }
                x = false;
            }
            System.out.println(res);
        }
        
    }
    //true表示可以算入
    public static boolean bijiao(String a,String b){
        if (a.length()!=b.length()){
            return true;
        }
        int n =a.length();
        for (int i = 0; i < n; i++) {
            if (b.charAt(i)=='?'||a.charAt(i)==b.charAt(i)){
                continue;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
