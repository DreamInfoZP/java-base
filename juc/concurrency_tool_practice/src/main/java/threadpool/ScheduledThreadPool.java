package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ScheduledThreadPoll.java v1.0  2020/1/8 7:49 下午
 * <p>
 * 定时执行任务
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        // 5秒后执行该任务
//        scheduledExecutorService.schedule(() -> {
//            System.out.println("执行的线程 线程名称 : " + Thread.currentThread().getName());
//        }, 5, TimeUnit.SECONDS);

        // 周期性执行的线程[重复]
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("执行线程 线程名称 : " + Thread.currentThread().getName());
        }, 1, 3, TimeUnit.SECONDS);
    }
}
