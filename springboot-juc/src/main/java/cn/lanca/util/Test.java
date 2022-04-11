package cn.lanca.util;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * project name:<font size = "1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size = "1"><b>TODO</b></font><br>
 * description:<font size = "1"><b>TODO</b></font><br>
 * company name:<font size = "1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: meihongliang@xiaowanjiankang.com" rel="nofollow">meihongliang<br>
 * @version 1.0.0<br>
 * @since [1] [2022/4/11 17:47] [meihongliang] [新建] <br>
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        futureTask();
        // extracted();
    }

    /**
     * <T>：表示参数含有T类型的泛型对象
     * T: 表示返回值是T类型对象
     */
    public <T> T method(T t) {
        // CODE
        return t;
    }

    /**
     * <T>:表示声明参数含有T类型的泛型对象
     */
    public <T> int method1(T t) {
        // CODE
        return 1;
    }

    /**
     * @param list list
     * @param <T>  t <strong>参数</strong>含有T类型的泛型对象 <br>
     * @return T 范型t
     */
    private <T> T getFirstObj(List<T> list) {

        return list.get(0);
    }






    private static void futureTask() throws InterruptedException, ExecutionException {
        // 无参 有返回值
        // ()->{
        // return "";
        // }
        FutureTask<String> stringFutureTask = new FutureTask<>(() -> {
            Thread.sleep(5 * 1000);
            return "5 * 1000";
        });
        // 妈的，要先run运行起来
        stringFutureTask.run();
        System.out.println(stringFutureTask.get());

        FutureTask<String> futureTask = new FutureTask<>(() -> {
            Thread.sleep(3000);
            System.out.println("calld方法执行了");
            return "call方法返回值";
        });
        futureTask.run();
        System.out.println("获取返回值: " + futureTask.get());

        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            Thread.sleep(3000);
            System.out.println("calld方法执行了1");
            return "call方法返回值1";
        });
        futureTask1.run();
        System.out.println("获取返回值1: " + futureTask1.get());
    }

    private static void extracted() {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> stringFutureTask = new FutureTask<>(myCallable);
        new Thread(stringFutureTask).start();
        try {
            System.out.println(stringFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
