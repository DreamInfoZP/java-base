package com.zp;

public class TicketThread implements Runnable{

    private int ticketCount = 100;

    @Override
    public void run() {
        while (ticketCount > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }
    }

    public void sale(){
        if (ticketCount > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (100-ticketCount+1) + "张票");
            ticketCount --;
        }
    }
}