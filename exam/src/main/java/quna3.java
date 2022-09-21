/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/21 20:26
 * @Description:
 */
public class quna3 {
   static public String transform (String input) {
        StringBuilder sb = new StringBuilder();
        int n = input.length();
        int i = 0;
        while (i<n){
            if (input.charAt(i)!='\\'){
                sb.append(input.charAt(i));
                i++;
            }
            else {
                if (i==n-1){
                    return String.valueOf(sb);
                }
                else if (input.charAt(i+1)=='\\'){
                    sb.append("\\");
                    i+=2;
                }
                else {
                    if (i+7>=n){
                        return sb.toString();
                    }
                    String temp = input.substring(i + 1, i +7);
                    if ("delete".equals(temp)&&i+9<=n-1&&input.charAt(i+7)=='{'){
                        i = i+7;
                        int start = i+1;
                        StringBuilder a = new StringBuilder();
                        while (i<n&&input.charAt(i)!='}'){
                            a.append(input.charAt(i));
                            i++;
                        }
                        if (i>=n){
                            return sb.append("delete").append(a).toString();
                        }
                        else {
                            long num;
                            try {
                                 num = Long.parseLong(input.substring(start, i));
                                if(num<=0){
                                    return sb.toString();
                                }
                            }catch (NumberFormatException e){
                                return sb.toString();
                            }
                            
                            if (num>sb.length()){
                                return "";
                            }
                            else {
                                while (num-->0){
                                    sb.deleteCharAt(sb.length()-1);
                                }
                                i++;
                            }
                        }
                    }
                   else {
                       return sb.toString();
                    }
                }
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
       String s = "\"abcd\\delete{2}\"";
        System.out.println(s);
        String transform = transform(s);
        System.out.println(transform);
    }
}
