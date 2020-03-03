package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date CinemaReadWrite.java v1.0  2020/1/17 4:39 下午
 */
public class CinemaReadWrite {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到读锁，正在读取中");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "读取完成，释放读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到写锁，正在写入");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "写入完成，释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(CinemaReadWrite::read, "Thread0").start();
        new Thread(CinemaReadWrite::read, "Thread1").start();
        new Thread(CinemaReadWrite::read, "Thread2").start();
        new Thread(CinemaReadWrite::write, "Thread3").start();
        new Thread(CinemaReadWrite::write, "Thread4").start();
    }
}
