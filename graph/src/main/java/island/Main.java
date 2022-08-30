//package island;
//
//import java.text.DecimalFormat;
//import java.util.Scanner;
//
///**
// * @Auther: YuZhenLong
// * @Date: 2022/8/30 19:17
// * @Description:
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        double [][] grass = new double[5][2];
//        for (int i = 0; i < grass.length; i++) {
//            grass[i][0] = in.nextDouble();
//            grass[i][1] = in.nextDouble();
//        }
//        path = Double.valueOf(0);
//        DecimalFormat decimalFormat =  new DecimalFormat("0");
//        backtrack(grass,0,-1);
//        System.out.println(decimalFormat.format(res));
//    }
//    static Double res = Double.MAX_VALUE;
//    static Double path ;
//    static boolean[]used = new boolean[5];
//    public static void backtrack(double [][]grass,int i,int k){
//        if (i==5){
//            //System.out.println(path);
//            double temp = Math.pow(Math.pow((grass[k][0]),2)+
//                    Math.pow((grass[k][1]),2),0.5);
//            path+=temp;
//            res = Double.min(res,path);
//            path -=temp;
//            return;
//        }
//        for (int j = 0; j < 5; j++) {
//            if (!used[j]){
//                used[j] = true;
//                double temp;
//                if (k==-1){
//                     temp = Math.pow(Math.pow((grass[j][0]),2)+
//                            Math.pow((grass[j][1]),2),0.5);
//                }
//                else {
//                     temp = Math.pow(Math.pow((grass[j][0] - grass[k][0]), 2) +
//                            Math.pow((grass[j][1] - grass[k][1]), 2), 0.5);
//                }
//                path+=temp;
////                if (path>=res){
////                    continue;
////                }
//                backtrack(grass,i+1,j);
//                path -=temp;
//                used[j] =false;
//            }
//        }
//    }
//}
