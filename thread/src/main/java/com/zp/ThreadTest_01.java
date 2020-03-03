package com.zp;

/**
 * 多线程的创建，方式一：继承Thread类
 * 1.创建一个继承Thread类的子类
 * 2.重写Thread类的run()    -->将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

/**
 * detail information Knowledge.md
 *
 * @author zhoupeng
 */
public class ThreadTest_01 {
    public static void main(String[] args) {

        /**
         * 常用方法
         * 1.start()：启动当前线程；调用当前线程的run()
         * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
         * 3.currentThread()：静态方法，返回执行当前代码的线程
         * 4.getName()：获取当前线程的名字
         * 5.setName()：设置当前线程的名字
         * 6.yield()：释放当前cpu的执行权
         * 7.join()：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，知道线程b完全执行完以后，线程a才结束阻塞状态
         * 8.stop()：强制线程生命期结束，不推荐使用
         * 9.sleep(long millis)：线程休眠指定时间
         * 10.isAlive()：当前线程是否存活
         *
         */
        MyThread thread = new MyThread();

        /**
         * 1.启动当前线程
         * 2.调用当前线程的run()
         * 3.一个线程只能启动一次     多次启动[java.lang.IllegalThreadStateException]
         * 注意：
         * 直接调用run方法
         * 等同于调类中的方法不会重新开启一个线程
         */
        thread.start();

        System.out.println("主线程");
    }
}
