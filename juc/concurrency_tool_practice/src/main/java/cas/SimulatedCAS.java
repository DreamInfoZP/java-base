package cas;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date SimulatedCAS.java v1.0  2020/1/21 1:59 下午
 * <p>
 * CAS实现原理等价与下面代码
 */
public class SimulatedCAS {
    private volatile int value;

    private synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return value;
    }
}
