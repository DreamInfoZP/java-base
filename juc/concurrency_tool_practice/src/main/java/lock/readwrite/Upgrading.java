package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date CinemaReadWrite.java v1.0  2020/1/17 4:39 下午
 */
public class Upgrading {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void readUpgrading() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到读锁，正在读取中");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "升级会带来阻塞");
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + "成功获取到写锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "读取完成，释放读锁");
            readLock.unlock();
        }
    }

    private static void writeDowngrading() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取到写锁，正在写入");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + "再不释放写锁的情况下，直接获取读锁，成功降级");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "写入完成，释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("先演示降级是可以的");
        Thread thread1 = new Thread(Upgrading::writeDowngrading, "thread1");
        thread1.start();
        thread1.join();

        System.out.println("--------------------------");
        System.out.println("演示升级是不行的");
        new Thread(Upgrading::readUpgrading, "thread2").start();
    }
}
