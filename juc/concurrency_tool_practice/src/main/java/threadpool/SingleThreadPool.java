package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date SingleThradPool.java v1.0  2020/1/8 2:59 下午
 */
public class SingleThreadPool {

    /**
     * 只会有一个线程
     */
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        executorService.submit(() -> {
            System.out.println("业务处理逻辑 线程名称：" + Thread.currentThread().getName());
        });
    }
}
