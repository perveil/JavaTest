package ThreadTest;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/*
*原子类 使得java语言中的有些非原子性操作变成原子性的，不会出现线程竞争的情况
* 原子性操作在java语言中，主要有基本数据类型的赋值和返回操作
*
* */
public class AtomicTest implements Runnable {
    private AtomicInteger i=new AtomicInteger(0);
    @Override
    public void run() {
           while (true){
           }
    }
    public void add(){
        i.addAndGet(2);
    }
     public int  getI() {
        return i.get();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.print("Aborting");
                System.exit(0);
            }
        },5000); //Timer 相当于一个计时器，5000ms后程序结束
        ExecutorService executorService=Executors.newCachedThreadPool();
        AtomicTest atomicTest=new AtomicTest();
        executorService.execute(atomicTest);
        while (true){
            int val=atomicTest.getI();
            if (val%2!=0){
                System.out.print(val);
                System.exit(0);
            }

        }
    }
}
