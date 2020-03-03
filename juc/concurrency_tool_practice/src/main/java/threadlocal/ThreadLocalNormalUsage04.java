package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ThreadLocalNormalUsage00.java v1.0  2020/1/7 4:52 下午
 * <p>
 * 1000个日期转换，使用线程池来处理
 */
public class ThreadLocalNormalUsage04 {

    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    /**
     * 解决重复创建1000次SimpleDateFormat对象
     * <p>
     * 此时该对象是共享的会出现线程安全问题 使用synchronized加锁
     * <p>
     * 此时线程需要等待
     */
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        /**
         * 这一段代码中 SimpleDateFormat 对象会被创建 1000次
         */
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalNormalUsage04().date(finalI);
                System.out.println(date);
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        threadPool.shutdown();
    }

    private String date(int seconds) {
        // 参数的单位是毫秒,从1970.1.1 00:00:00 GMT计时
        Date date = new Date(seconds * 1000);
        String s;
        synchronized (ThreadLocalNormalUsage04.class) {
            s = dateFormat.format(date);
        }
        return s;
    }
}
