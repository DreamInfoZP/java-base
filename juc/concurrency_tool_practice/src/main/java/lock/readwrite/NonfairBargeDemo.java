package lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date NonfairBargeDemo.java v1.0  2020/1/17 5:36 下午
 */
public class NonfairBargeDemo {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);

    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    private static void read() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取读锁");

        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁,正在读取");
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取写锁");

        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁,正在写入");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(NonfairBargeDemo::write, "Thread1").start();
        new Thread(NonfairBargeDemo::read, "Thread2").start();
        new Thread(NonfairBargeDemo::read, "Thread3").start();
        new Thread(NonfairBargeDemo::write, "Thread4").start();
        new Thread(NonfairBargeDemo::read, "Thread5").start();

        new Thread(() -> {
            Thread thread[] = new Thread[1000];
            for (int i = 0; i < 1000; i++) {
                thread[i] = new Thread(NonfairBargeDemo::read, "子线程创建的Thread" + i);
            }

            for (int i = 0; i < 1000; i++) {
                thread[i].start();
            }
        }).start();
    }

}
