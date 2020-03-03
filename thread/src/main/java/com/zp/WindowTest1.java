package com.zp;

class Window1 implements Runnable {
    private static int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票,票号为: " + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

/**
 * @author zhoupeng
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        t1.setName("1: ");
        Thread t2 = new Thread(w);
        t2.setName("2: ");
        Thread t3 = new Thread(w);
        t3.setName("3: ");
        t1.start();
        t2.start();
        t3.start();

    }
}
