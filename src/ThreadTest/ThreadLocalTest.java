package ThreadTest;

public class ThreadLocalTest {
    ThreadLocal<Long> longThreadLocal=new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    public void set (){
        longThreadLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }
    public long getLong() {
        return longThreadLocal.get();
    }
    public String getString() {
        return stringLocal.get();
    }
    public static void main(String[] args) throws InterruptedException {
      ThreadLocalTest test=new ThreadLocalTest();
      test.set();
      System.out.println(test.getLong());
      System.out.println(test.getString());

        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                //Thread1 线程下
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        //main线程环境下
        System.out.println(test.getLong());
        System.out.println(test.getString());


    }
}
