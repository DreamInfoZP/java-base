package lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date GetHoldCount.java v1.0  2020/1/17 10:54 上午
 */
public class GetHoldCount {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
}
