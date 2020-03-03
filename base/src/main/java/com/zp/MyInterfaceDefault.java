package com.zp;

/**
 * @author zhoupeng
 */
public interface MyInterfaceDefault {

    /**
     * 抽象方法
     */
    void methodAbs();

    /**
     * 抽象方法
     */
    default void methodAbs2() {
        System.out.println("我是一个接口默认方法");
    }
}
