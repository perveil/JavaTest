package ThreadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 题目：不使用Synchronized 实现互斥量
* */
class SynchronizedClass{
    /*
    * 在线程对其进行共享资源进行使用的时候，JVM负责跟踪对象被加锁的次数,当一个任务第一次使用资源时，count=1,
    * 此时次任务如果再继续使用此资源时，count++ 当对资源的每一次使用结束时，count--，直到count=0,此时说明
    * 该资源解锁，完全被释放
    * */
    private static  int count=0;

    /*
    *使用Lock对象显式实现互斥机制，比Synchronized关键字使用的代码多，只有在解决特殊问题时，才会使用Lock对象
    * 比如去解决：尝试在一段时间内去获得锁，可以在一段时间内获得成功，也可以失败
    * Lock类提高了细粒度的控制力
    * */
    private int CurrentNum=0;
    private Lock lock=new ReentrantLock();

    public int next(){
        lock.lock(); //上锁
        try{
            CurrentNum++;
            return CurrentNum;
        }finally {
            lock.unlock(); //任务完成，加锁
        }

    }

}


public class SynchronizedTest {
}
