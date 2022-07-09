package dichotomy.realproblem;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/9 20:37
 * @Description:
 */
public class MinEatingSpeed {
    // 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉
    //f(x)单调递减
    long f(int []piles,int x){
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours+=piles[i]/x;
            if (piles[i]%x>0){
                hours++;
            }
        }
        System.out.println(hours);
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        while (left<=right){
            int mid = left+(right-left)/2;
            System.out.println("left:"+left+"right:"+right);
            System.out.println("mid:"+mid);
            if (f(piles,mid)<=h){
                right = mid-1;
            }
            //要根据图像进行判断
            else if (f(piles,mid)>h){
                left = mid + 1;
            }

        }
        return left;
    }
}
