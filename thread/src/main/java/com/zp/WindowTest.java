package com.zp;

/**
 * @author zhoupeng
 */

class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ": 卖票,票号为: " + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }

    public Window(String name) {
        this.setName(name);
    }
}

public class WindowTest {

    public static void main(String[] args) {
        /**
         * 重复卖票
         *
         * repeatTicket();
         */


    }

    private static void repeatTicket() {
        Window w1 = new Window("窗口1");
        Window w2 = new Window("窗口2");
        Window w3 = new Window("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
