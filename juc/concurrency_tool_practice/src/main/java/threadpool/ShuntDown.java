package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ShuntDown.java v1.0  2020/1/8 8:34 下午
 * <p>
 * 关闭线程
 */
public class ShuntDown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程名称 : " + Thread.currentThread().getName());
            });
        }
    }
}
