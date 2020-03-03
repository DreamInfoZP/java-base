package lock.spinlock;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date SpinLock.java v1.0  2020/1/19 9:07 下午
 */
public class SpinLock {
    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void luck() {
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null, current)) {
            System.out.println(Thread.currentThread().getName() + "自旋锁获取失败,再次尝试");
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
            spinLock.luck();
            System.out.println(Thread.currentThread().getName() + "获取到自旋锁");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                spinLock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放自旋锁成功");
            }
        };

        new Thread(runnable, "thread1").start();
        new Thread(runnable, "thread2").start();

    }
}


