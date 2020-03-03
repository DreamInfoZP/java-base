package lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date TryInterruptibly.java v1.0  2020/1/12 5:21 下午
 */
public class LockInterruptibly implements Runnable {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptibly lockInterruptibly = new LockInterruptibly();
        Thread t0 = new Thread(lockInterruptibly);
        Thread t1 = new Thread(lockInterruptibly);
        t0.start();
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        t0.interrupt();
        /**
         * 可能会出现不一样的结果
         *
         * Thread-0尝试获取锁
         * Thread-1尝试获取锁
         * Thread-0获取到了锁
         * Thread-0睡眠期间被中断了
         * Thread-0释放了锁
         * Thread-1获取到了锁
         * Thread-1释放了锁
         */
        t1.interrupt();
        /**
         * 可能会出现不一样的结果
         *
         * Thread-0尝试获取锁
         * Thread-0获取到了锁
         * Thread-1尝试获取锁
         * Thread-1获取锁期间被中断了
         * Thread-0释放了锁
         */
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");

        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "睡眠期间被中断了");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放了锁");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "获取锁期间被中断了");
        }
    }
}
