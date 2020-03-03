package lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date PessimismOptimismLock.java v1.0  2020/1/16 8:47 下午
 * <p>
 * 乐观锁和悲观锁对a进行++
 */
public class PessimismOptimismLock {
    int a;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    public synchronized void testMethod() {
        a++;
    }
}
