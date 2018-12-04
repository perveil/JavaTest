package ThreadTest;

import java.util.ArrayList;
import java.util.concurrent.*;

// Runnable 接口定义一个可执行任务，之后依托Thread类来执行
class task implements Runnable{
    private  static int startCount=10;
    private  int id=startCount++;
    public task(){}
    @Override
    public void run() {
        while(id-->0){
            System.out.println("$"+id);
        }
    }
}
/*
*Callable是一个具有类型参数的泛型，Callable<String> 的声明要求 call函数的返回值也是String
* Callable对象的调用必须依赖于Executors管理器，Pool.submit(Callable c) 返回一个Future<T> 对象
* Future对象可以调用IsDone方法检查任务是否被执行完毕，返回一个boolean值
* */
class CallTask implements Callable{
    private int id;
    CallTask(int id){
          this.id=id;
    }
    @Override
    public Object call() throws Exception {
        return "this.id="+id;
    }
}
/*sleep方法，使当前线程停止指定的时间，和Thread.yield()方法不同，
yield()方法调用之后将其交给线程调度器去管理，选择性的停止和开始线程，当在一个单一线程里边调用yield时，效果和不调用一样，
因为只有一个线程在调用，切换失败
* */
public class StartTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1.通过Executors新建一个线程池
        ExecutorService executorService=Executors.newCachedThreadPool();
        ArrayList<Future<String>> futures=new ArrayList<>();
        for (int i=0;i<5;i++){
            futures.add(executorService.submit(new CallTask(i)));
        }
        for (Future<String> future:futures){
            try{
                System.out.println(future.get()+" "+future.isDone());
            }catch (InterruptedException e){
                e.printStackTrace();

            }catch (ExecutionException e){
                e.printStackTrace();

            } finally {
                executorService.shutdown();
            }

        }


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);  //主线程休眠
                } catch (InterruptedException e) {

                }
                System.out.print("2"); //1
            }
        });
        t.start();

        t.join();
        System.out.print("1"); //2
    }
}
