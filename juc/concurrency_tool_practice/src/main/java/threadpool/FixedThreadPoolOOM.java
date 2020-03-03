package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date FixedThreadPoolOOM.java v1.0  2020/1/8 2:44 下午
 * <p>
 * 设置 VM options 大小 -Xmx8m -Xms8m
 *
 * 产生
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 	at java.util.concurrent.LinkedBlockingQueue.offer(LinkedBlockingQueue.java:416)
 * 	at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1371)
 * 	at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
 * 	at threadpool.FixedThreadPoolOOM.main(FixedThreadPoolOOM.java:20)
 */
public class FixedThreadPoolOOM {

    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.submit(new SubThread());
        }
    }
}

class SubThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
