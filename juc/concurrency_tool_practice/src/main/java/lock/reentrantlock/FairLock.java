package lock.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date FairLock.java v1.0  2020/1/17 11:28 上午
 */
public class FairLock {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Job implements Runnable {
    PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始打印");
        printQueue.printJob(new Object());
        System.out.println(Thread.currentThread().getName() + "打印完成");
    }
}

class PrintQueue {
    /**
     * 锁是否公平由该参数决定
     */
    private Lock queueLock = new ReentrantLock(false);

    public void printJob(Object document) {

        /**
         * 一个线程需要获取两把锁才能执行完程序
         */
        queueLock.lock();
        try {
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + "正在打印，需要" + duration + "秒");
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }

        queueLock.lock();
        try {
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + "正在打印，需要" + duration + "秒");
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}

/**
 * 公平锁结果
 * Thread-0开始打印
 * Thread-0正在打印，需要8
 * Thread-1开始打印
 * Thread-2开始打印
 * Thread-3开始打印
 * Thread-4开始打印
 * Thread-5开始打印
 * Thread-6开始打印
 * Thread-7开始打印
 * Thread-8开始打印
 * Thread-9开始打印
 * Thread-1正在打印，需要9
 * Thread-2正在打印，需要9
 * Thread-3正在打印，需要4
 * Thread-4正在打印，需要4
 * Thread-5正在打印，需要3
 * Thread-6正在打印，需要6
 * Thread-7正在打印，需要8
 * Thread-8正在打印，需要2
 * Thread-9正在打印，需要1
 * Thread-0正在打印，需要9
 * Thread-0打印完成
 * Thread-1正在打印，需要8
 * Thread-1打印完成
 * Thread-2正在打印，需要4
 * Thread-2打印完成
 * Thread-3正在打印，需要4
 * Thread-3打印完成
 * Thread-4正在打印，需要6
 * Thread-4打印完成
 * Thread-5正在打印，需要6
 * Thread-5打印完成
 * Thread-6正在打印，需要1
 * Thread-6打印完成
 * Thread-7正在打印，需要7
 * Thread-7打印完成
 * Thread-8正在打印，需要2
 * Thread-8打印完成
 * Thread-9正在打印，需要5
 * Thread-9打印完成
 */


/**
 * Thread-0开始打印
 * Thread-0正在打印，需要9秒
 * Thread-1开始打印
 * Thread-2开始打印
 * Thread-3开始打印
 * Thread-4开始打印
 * Thread-5开始打印
 * Thread-6开始打印
 * Thread-7开始打印
 * Thread-8开始打印
 * Thread-9开始打印
 * Thread-0正在打印，需要7秒
 * Thread-0打印完成
 * Thread-1正在打印，需要8秒
 * Thread-1正在打印，需要3秒
 * Thread-1打印完成
 * Thread-2正在打印，需要2秒
 * Thread-2正在打印，需要3秒
 * Thread-2打印完成
 * Thread-3正在打印，需要5秒
 * Thread-3正在打印，需要9秒
 * Thread-3打印完成
 * Thread-4正在打印，需要10秒
 * Thread-4正在打印，需要7秒
 * Thread-4打印完成
 * Thread-5正在打印，需要2秒
 * Thread-5正在打印，需要1秒
 * Thread-5打印完成
 * Thread-6正在打印，需要8秒
 * Thread-6正在打印，需要10秒
 * Thread-6打印完成
 * Thread-7正在打印，需要10秒
 * Thread-7正在打印，需要5秒
 * Thread-7打印完成
 * Thread-8正在打印，需要5秒
 * Thread-8正在打印，需要10秒
 * Thread-8打印完成
 * Thread-9正在打印，需要6秒
 * Thread-9正在打印，需要5秒
 * Thread-9打印完成
 *
 */
