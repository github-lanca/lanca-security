package cn.lanca.current;

import lombok.Synchronized;

/**
 * Synchronized注解
 * Synchronized关键字
 *
 * @author meihonglaing
 * @since 2022/3/2 10:35
 */
public class Test {


    /**
     * 关键字在方法前
     */
    public synchronized void test1() {

    }

    /**
     *
     */
    public void test2() {
        synchronized (this) {
            System.out.println("threadName: " + Thread.currentThread().getName());
        }
    }

    /**
     * 注解在方法上
     */
    @Synchronized
    public void test3() {

    }

    /**
     * 修饰一个静态的方法+关键字
     */
    public synchronized static void test4() {

    }

    /**
     * 修饰一个类
     */
    public void test5() {
        synchronized (Test.class) {
            System.out.println("threadName: " + Thread.currentThread().getName());
        }
    }
}
