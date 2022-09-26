import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/26 10:38
 * @Description:
 */
public class tonghua {
    
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = "2022-9-26";
        Date date1 = format.parse(s);
        Date date2 = format.parse(str);
        int res=(int)(date2.getTime()-date1.getTime())/(1000*3600*24);
        System.out.println(res);
    }
    




}
