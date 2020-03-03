package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ShutDown.java v1.0  2020/1/12 10:29 上午
 * <p>
 * 非暴力关闭
 * 等待被提交的线程执行完毕
 * 执行了ShutDown 不能向线程池中提交新的线程
 */
public class ShutDown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new ShuntDownTask());
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(executorService.awaitTermination(3L, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(executorService.isShutdown());
//        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());

        //  Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task threadpool.ShuntDownTask@17695df3 rejected from java.util.concurrent.ThreadPoolExecutor@6c9f5c0d[Shutting down,
        // executorService.execute(new ShuntDownTask());

    }
}

class ShuntDownTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程名称" + Thread.currentThread().getName());
    }
}
