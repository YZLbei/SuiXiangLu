import java.util.Scanner;

/**
 * @Auther: YuZhendouble
 * @Date: 2022/9/14 20:25
 * @Description:
 */
public class xiecheng4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        System.out.println((int)sum(n)%1000000007);
    }
    static  double sum(double n){
        double sum =0;
        double k = n*4-4;
        int sum1 = 0;
        for (double i = 1; i <=4; i++) {
            
            sum1+=i;
        }
        sum+=sum1*2;
        double sum2 = 0;
        for (double i = 5; i <=k; i++) {
            sum2+=i;
        }
        sum+= sum2*3;
        double sum3 = 0;
        for (double i = k+1;i <=n*n; i++) {
            sum3+=i;
        }
        sum+=sum3*4;
        return sum;
    }
    
    static String add(String s1,String s2) {
            //先将输入的两个串逆序生成字符数组
            char[] a = new StringBuilder(s1).reverse().toString().toCharArray();
            char[] b = new StringBuilder(s2).reverse().toString().toCharArray();

            //结果数组的最大长度为两个数组中长度较大的那个再加1
            int lenA = a.length;
            int lenB = b.length;
            int maxlen = lenA > lenB ? lenA : lenB;
            int[] result = new int[maxlen+1];

            //如果当前位超过了最大的长度，补0即可
            for(int i=0; i<maxlen+1; i++) {
                int aint = i < lenA ? (a[i] - '0') : 0;
                int bint = i < lenB ? (b[i] - '0') : 0;
                result[i] = aint + bint;
            }

            //遍历结果数组，大于10进位，当前位取10的模
            for(int i=0; i<result.length; i++) {
                if(result[i] >= 10) {
                    result[i+1] += result[i] /10;
                    result[i] %= 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (result[maxlen] != 0) {
                sb.append(result[maxlen]);
            }

            for(int i=maxlen-1; i>=0; i--) {
                sb.append(result[i]);
            }
            return sb.toString();
        }
    static String multiply(String s1,String s2) {
        //符号问题，如果两字符串异号，最后的结果为'-'
        char signA = s1.charAt(0);
        char signB = s2.charAt(0);
        char sign = '+';
        if(signA == '-' && signB != '-') {
            s1 = s1.substring(1);
            sign = signA;
        }
        if(signB == '-' && signA != '-') {
            s2 = s2.substring(1);
            sign = signB;
        }

        char[] a = new StringBuilder(s1).reverse().toString().toCharArray();
        char[] b = new StringBuilder(s2).reverse().toString().toCharArray();
        int lenA = a.length;
        int lenB = b.length;

        //结果数组
        int maxLen = lenA + lenB;
        int[] ret = new int[maxLen];

        //每一位分别相乘
        for(int i=0; i<lenA; i++) {
            for(int j=0; j<lenB; j++) {
                ret[i+j] += (a[i] - '0') * (b[j] - '0');
            }
        }

        //大于10，进位
        for(int i=0; i<ret.length; i++) {
            if(ret[i] >= 10) {
                ret[i+1] += ret[i] /10;
                ret[i] %= 10;
            }
        }

        //如果第一位为0，不输出
        StringBuilder sb = new StringBuilder();
        if(ret[ret.length-1] != 0) {
            sb.append(ret[ret.length-1]);
        }
        for(int i=ret.length-2; i>=0; i--) {
            sb.append(ret[i]);
        }
        if (sign == '-') { //如果是异号，在结果中插入'-'
            sb.insert(0, sign);
        }
        return sb.toString();
    }
}
