//import java.util.*;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @Auther: YuZhenLong
// * @Date: 2022/9/8 18:59
// * @Description:
// */
//public class wanmei1 {
//    public static Collection<Runnable> makeTasks(List<Runnable> tasks){
//        Collection<Runnable> res = new ArrayList<>();
//        final Executor executor;
//        Runnable active;
//        for (Runnable task : tasks) {
//            CompletableFuture.runAsync(()->task.run());
//        }
////        
//    }
//}
