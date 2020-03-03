一个Java应用程序java.exe，其实至少有三个线程：
    main()主线程
    gc线程，垃圾回收线程
    异常处理线程
  发生异常，会影响主线程

并行：多个CPU同时执行多个任务。多个人同时做不同的事情
并发：一个CPU(采用时间片)同时执行多个任务。秒杀、多个人做相同的事情

多线程场景
1.程序需要同时执行两个或者多个任务
2.程序需要实现一些等待的任务，如用户输入、文件读写、操作、网络操作、搜索等
3.需要一些后台运行的程序

线程的优先等级【抢占cpu优先级高的概率比较高，并不意味这高的执行完才执行低优先级】
MAX_PRIORITY:10
MIN_PRIORITY:1
NORM_PRIORITY:5 [default]
涉及方法
getPriority():返回线程优先值
setPriority():改变线程的优先级


比较Thread和Runnable
优先选择Runnable接口的方式
    1.实现的方式没有类的单继承性的局限
    2.实现的方式更适合来处理多个线程有共享数据的情况
联系：public class Thread implements Runnable
相同点：两种方式都需要重写run()，将线程要执行的逻辑申明在run()中





