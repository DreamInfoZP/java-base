package com.zp;

import java.util.HashSet;
import java.util.Set;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date Test01.java v1.0  2020/1/7 5:58 下午
 */
public class Test01 {
    private static int ticker = 100;

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                while (ticker > 0) {
                    ticker--;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    set.add(ticker);
                    System.out.println(ticker + "窗口号" + finalI);
                }

            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(set.size());
    }
}
