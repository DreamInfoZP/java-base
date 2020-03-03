package com.zp.juc;

import javax.sound.midi.SoundbankResource;
import java.util.Calendar;
import java.util.Date;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ThreadTest.java v1.0  2020/1/7 3:20 下午
 */
public class ThreadTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("start: " + start);

        int x = 100;
        x = summation(x);
        int y = 1;
        y = summation(y);
        long end = System.currentTimeMillis();
        System.out.println("end: " + end);
        System.out.println("sum time ：" + (end - start));

        System.out.println(x + y);

    }

    public static int summation(int a) {
        for (long i = 0; i < 999999999; i++) {
            a++;
        }
        return a;
    }
}




