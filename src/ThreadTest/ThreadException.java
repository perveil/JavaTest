package ThreadTest;
/*
  在没有使用线程池之前，thread/runnable接口中的run方法的异常只能在run方法里边捕获，不能冒泡到调用线程上边

  接下来要说的是：线程池的异常处理器，线程池让每一个生成的线程都附着一个异常处理器
 */

import javassist.bytecode.analysis.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.print("catch "+e);
    }
}
class HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
       Thread thread=new Thread(r);
       thread.setUncaughtExceptionHandler(new ExceptionHandler());
        return thread;
    }
}
class ExceptionThread implements  Runnable{
    @Override
    public void run() {
        throw  new RuntimeException();
    }
}

public class ThreadException {
    public static void main(String[] args) {
        ExecutorService service=Executors.newCachedThreadPool(new HandlerThreadFactory());
        service.execute(new ExceptionThread());

    }
}
