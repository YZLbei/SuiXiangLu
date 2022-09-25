import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/25 19:08
 * @Description:
 */
public class zijie1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        //TreeNode root = new TreeNode(0);
        //List<LinkedList<String>>[]str = new List[n];
        LinkedList<LinkedList<String>> str = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");

            op(s1);
        }
        for (int i = 0; i < exist.size(); i++) {
            op(exist.get(i));
        }
        int target = in.nextInt();

        System.out.println(map.get(0).get(0));
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
       if (target-1>=map.size()){
           System.out.println(0);
       }
       else {
           System.out.println(map.get(target - 1).size());
       }
    }
    static LinkedList<LinkedList<String>> map = new LinkedList<>();
    static LinkedList<String[]>exist = new LinkedList<>();
    static public void op(String[]str){
        if (map.size()==0){
            for (int i = 0; i < str.length; i++) {
                LinkedList<String>temp = new LinkedList<>();
                temp.add(str[i]);
                map.add(temp);
            }
            return;
        }
        //第几代
        int location = -1;
        int find = -1;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < map.size(); j++) {
                if (map.get(j).contains(str[i])){
                    location = j;
                    find = i;
                    break;
                }
            }
            if (location!=-1){
                break;
            }
        }
        if (location==-1){
            exist.add(str);
        }
        else {
            int []num = new int[str.length];
            for (int i = 0; i < num.length; i++) {
                num[i] = i-find+ location ;
            }
            for (int i = 0; i < str.length; i++) {
                if (num[i]<0){
                    LinkedList<String>temp = new LinkedList<>();
                    temp.add(str[i]);
                    map.addFirst(temp);
                }
                else if (map.size()<=num[i]){
                        LinkedList<String>temp = new LinkedList<>();
                        temp.add(str[i]);
                        map.add(temp);
                }
                else if (map.get(num[i]).contains(str[i])){
                    continue;
                }
                else if(!map.get(num[i]).contains(str[i])){
                        //LinkedList<String>temp = new LinkedList<>();
                        map.get(i).add(str[i]);
                }
                }
            }
            
        }
        
        
}
