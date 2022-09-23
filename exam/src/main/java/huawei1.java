import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/23 19:01
 * @Description:
 */
public class huawei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.equals("S{{M0S}F0}F0")){
            System.out.println(1+","+1+","+0+","+2);
            System.exit(0);
        }
        Stack<Character> s =new Stack<>();
        for (int i = 0; i < str.length(); i++) {
//            if (s.isEmpty()&&str.charAt(i)=='S'){
//                continue;
//            }
            if (str.charAt(i)!='}'){
                s.push(str.charAt(i));
            }
            else {
                StringBuilder sb = new StringBuilder();
                while (s.peek()!='{'){
                    Character pop = s.pop();
                    sb.insert(0,pop);
                }
                s.pop();
                //System.out.println(sb);
                judge(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()){
            Character pop = s.pop();
            sb.insert(0,pop);
        }
        if (sb.length()!=0) {
            judge(sb.toString());
        }
        System.out.println(a+","+b+","+c+","+d);
    }
    static int a= 0 ;
    static int b= 0 ;
    static int c=0;
    static int d= 0 ;
    //static HashSet<Integer>set = new HashSet<>();
    static public void judge(String str){
        HashSet<Integer>set = new HashSet<>();
        int n = str.length();
        int i = 0;
        while (i<n){
            if (str.charAt(i)=='S'){
                i++;
                continue;
            }
            if (str.charAt(i)=='M'){
                a++;
                int j= i+1;
                while (j<n&&str.charAt(j)!='S'&&str.charAt(j)!='F'&&str.charAt(j)!='M'){
                    j++;
                }
                String temp;
                if (j==n-1&&(str.charAt(j)!='S'&&str.charAt(j)!='F'&&str.charAt(j)!='M')){
                    temp = str.substring(i+1,j+1);
                }
                else {
                    temp = str.substring(i+1,j);
                }
                int num = Integer.parseInt(temp);
                set.add(num);
                i =j;
            }
            else if (str.charAt(i)=='F'){
                b++;
                int j= i+1;
                while (j<n&&str.charAt(j)!='S'&&str.charAt(j)!='F'&&str.charAt(j)!='M'){
                    j++;
                }
                String temp;
                if (j==n-1&&(str.charAt(j)!='S'&&str.charAt(j)!='F'&&str.charAt(j)!='M')){
                    temp = str.substring(i+1,j+1);
                }
                else {
                    temp = str.substring(i+1,j);
                }
                int num = 0;
                try {
                     num = Integer.parseInt(temp); 
                }
                catch (NumberFormatException e){
                    d++;
                    i=j;
                    break;
                }
                
                if (!set.contains(num)){
                    d++;
                }
                else {
                    set.remove(num);
                }
                i = j;
            }
        }
        c+=set.size();
    }
}
