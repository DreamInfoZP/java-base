package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date AtomicArrayDemo.java v1.0  2020/1/20 3:05 下午
 */
public class AtomicArrayDemo {

    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threadIncrementer = new Thread[100];
        Thread[] threadDecrementer = new Thread[100];

        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrementer decrementer = new Decrementer(atomicIntegerArray);
        for (int i = 0; i < 100; i++) {
            threadIncrementer[i] = new Thread(incrementer);
            threadDecrementer[i] = new Thread(decrementer);
            threadIncrementer[i].start();
            threadDecrementer[i].start();
        }

        for (int i = 0; i < 100; i++) {
            threadIncrementer[i].join();
            threadDecrementer[i].join();
        }

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            if (atomicIntegerArray.get(i) != 0) {
                System.out.println("发现非零值:" + atomicIntegerArray.get(i));
            }
        }
        System.out.println("运行结束");
    }
}

class Decrementer implements Runnable {

    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    private AtomicIntegerArray array;

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.decrementAndGet(i);
        }
    }
}

class Incrementer implements Runnable {

    private AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.incrementAndGet(i);
        }
    }
}
