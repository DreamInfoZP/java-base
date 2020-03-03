package threadpool;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ForLoop.java v1.0  2020/1/8 11:31 上午
 */
public class ForLoop {

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new Task());
//            thread.start();
//        }
//    }
//
//    static class Task implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println("执行任务");
//        }
//    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                System.out.println("执行任务");
            }).start();
        }
    }
}
