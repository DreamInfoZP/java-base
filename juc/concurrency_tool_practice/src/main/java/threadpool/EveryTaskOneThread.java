package threadpool;

import javafx.concurrent.Task;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date EveryTaskOneThread.java v1.0  2020/1/8 11:27 上午
 */
public class EveryTaskOneThread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }

//    public static void main(String[] args) {
//        new Thread(() -> {
//            System.out.println("执行任务");
//        }).start();
//    }
}
