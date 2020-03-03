package atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date LongAccumulatorDemo.java v1.0  2020/1/21 11:34 上午
 * <p>
 * LongAccumulator的用法
 */
public class LongAccumulatorDemo {
    public static void main(String[] args) {
//        LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);

        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0);
//        accumulator.accumulate(1);
//        accumulator.accumulate(2);

        ExecutorService executor = Executors.newFixedThreadPool(8);

        IntStream.range(1, 10).forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println(executor);

        System.out.println(accumulator.getThenReset());
    }
}
