package cas;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date TwoThreadsCompetition.java v1.0  2020/1/21 2:06 下午
 */
public class TwoThreadsCompetition implements Runnable {

    private volatile int value;

    private synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        TwoThreadsCompetition r = new TwoThreadsCompetition();
        r.value = 0;
        Thread thread = new Thread(r);
        Thread thread1 = new Thread(r);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(r.value);
    }

    @Override
    public void run() {
        compareAndSwap(0, 1);
    }
}
