package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date AtomicIntegerFieldUpdaterDemo.java v1.0  2020/1/20 3:33 下午
 * <p>
 * AtomicIntegerFieldUpdater的用法
 */
public class AtomicIntegerFieldUpdaterDemo implements Runnable {

    static Candidate tom;

    static Candidate peter;

    public static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score++;
            scoreUpdater.incrementAndGet(tom);

        }
    }

    private static class Candidate {
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        tom = new Candidate();
        peter = new Candidate();

        AtomicIntegerFieldUpdaterDemo r = new AtomicIntegerFieldUpdaterDemo();

        Thread thread = new Thread(r);
        Thread thread1 = new Thread(r);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println("升级的对象：" + tom.score);
        System.out.println("普通变量：" + peter.score);

    }
}
