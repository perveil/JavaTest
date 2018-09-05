package ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class SimpleDaemon implements Runnable{

    @Override
    public void run() {
        try{
            while (true){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+""+this);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
/*
*编写后台程序工厂类，使用其来后台程序的声明方式
* */
class DaemonFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread();
        thread.setDaemon(true);
        return thread;
    }
}
/*
*后台进程，是指在程序运行时在后台提供一种通用服务的线程，并且这种线程处于一种可有可无的状态，
* 当所有的后台线程终止的时候，程序不一定终止，而当程序终止的时候，后台进程是一定会终止的，
* 对于一个线程，如何标识其为后台进程，是通过setDaemon(boolean)方法指定的
*在一个后台线程中启动一个线程时，默认是后台线程
* */
/*
* try .catch .finally 在后台线程面前，可能就不是我们想的那样了，
* 在之前我们确定了finally 语句块是每try一次都会执行的，但是在后台线程中的run方法使用时，就可能finally语句块是不执行的
* 比如，声明后台线程的main线程在启动了后台线程之后立即停止时，jvm会立即停止所有的后台线程，此时可能还没有进行到finally语句块
* 所以此时的finally语句块是不执行的
* */
public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        /*
        * public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {}
        * 声明线程管理器的时候传入写好的"后台线程工厂"类，表明线程管理器将会管理后台线程
        * */
        ExecutorService executorService=Executors.newCachedThreadPool(new DaemonFactory());
        for (int i=0;i<5;i++){
            Thread thread=new Thread(new SimpleDaemon());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("All 后台进程启动了");
        Thread.sleep(2000);

    }
}
