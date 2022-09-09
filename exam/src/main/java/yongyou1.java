/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/9 19:33
 * @Description:
 */
public class yongyou1 {
    public long calculateTotal (int count) {
        if (count==1||count==2){
            return 1;
            
        }
        else {
            return calculateTotal(count-1)+calculateTotal(count-2);
        }
    }
}
