package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date CacheThreadPool.java v1.0  2020/1/8 7:36 下午
 */
public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                System.out.println("业务处理 线程名称 : " + Thread.currentThread().getName());
            });
        }
    }
}
