package com.zp;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date Test02.java v1.0  2020/1/7 6:52 下午
 */
public class Test02 {
    public static void main(String[] args) {

        TicketThread ticketThread = new TicketThread();
        Thread t1 = new Thread(ticketThread, "窗口1--");
        Thread t2 = new Thread(ticketThread, "窗口2--");
        t1.start();
        t2.start();
    }
}
