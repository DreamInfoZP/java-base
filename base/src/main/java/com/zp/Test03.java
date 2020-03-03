package com.zp;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date Test03.java v1.0  2020/1/8 10:28 上午
 *
 * 内存溢出异常
 * java.lang.OutOfMemoryError: Java heap space
 */
public class Test03 {

    private static List<Byte[]> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                Byte[] bytes = new Byte[1024 * 1024 * 1024];
                list.add(bytes);
            }).start();
        }
    }
}
