package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ThreadLocalNormalUsage00.java v1.0  2020/1/7 4:52 下午
 * <p>
 * 两个线程打印日期
 */
public class ThreadLocalNormalUsage00 {

    public static void main(String[] args) {
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage00().date(10);
            System.out.println(date);
        }).start();
        new Thread(() -> {
            String date = new ThreadLocalNormalUsage00().date(1007);
            System.out.println(date);
        }).start();
    }

    private String date(int seconds) {
        // 参数的单位是毫秒,从1970.1.1 00:00:00 GMT计时
        Date date = new Date(seconds * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
