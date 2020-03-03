package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date AtomicIntegerDemo1.java v1.0  2020/1/20 2:50 下午
 * <p>
 * AtomicInteger基本用法，对比非原子类的线程安全问题，使用了原子类之后，不需要加锁，也可以保证线程安全
 */
public class AtomicIntegerDemo1 implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public void incrementAtomic() {
        atomicInteger.getAndIncrement();
    }

    //    synchronized 加锁才可以保证原子性
    private static volatile int basicCount = 0;

    public void incrementBasic() {
        basicCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementAtomic();
            incrementBasic();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerDemo1 atomicIntegerDemo1 = new AtomicIntegerDemo1();

        Thread thread = new Thread(atomicIntegerDemo1);
        Thread thread1 = new Thread(atomicIntegerDemo1);

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println("原子类的结果: " + atomicInteger);
        System.out.println("非原子类的结果: " + basicCount);
    }
}
