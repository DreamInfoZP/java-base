package threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ShutDownNow.java v1.0  2020/1/12 10:49 上午
 */
public class ShutDownNow {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new ShutDownNowTask());
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Runnable> runnableList = executorService.shutdownNow();

    }
}

class ShutDownNowTask implements Runnable {
    @Override
    public void run() {
        System.out.println("线程名称 " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("线程被中断了 " + Thread.currentThread().getName());
            e.printStackTrace();
        }
    }
}
