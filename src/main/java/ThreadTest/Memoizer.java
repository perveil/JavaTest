package ThreadTest;

import java.util.Map;
import java.util.concurrent.*;

/*
* 线程安全的一个缓存器
* */
interface  Compute<K,V>{
    V compute(K arg) throws InterruptedException;
}
public class Memoizer<K,V> implements Compute<K,V>{
    private  final Map<K, Future<V>> cache=new ConcurrentHashMap<>();
    /*
    *使用 Future<V> 是为了 避免重复开销大的计算，使用线程的返回值任务Callable
    * */
    private  final  Compute<K,V> compute;   //不同的计算方法
    Memoizer(Compute<K,V> compute){
        this.compute=compute;
    }
    @Override
    public V compute(K arg) throws  InterruptedException {
        while(true){
            Future<V> flag=cache.get(arg);
            if (flag==null){
                Callable<V> result=new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return compute.compute(arg);
                    }
                };
                FutureTask<V> ft=new FutureTask<>(result);
                flag=cache.putIfAbsent(arg,  ft); //CurrentHashMap 的指定原子操作，避免“先检查后运行”线程不安全场景的出现
                if (flag==null){
                    flag= ft;
                    ft.run();
                }
            }
            try{
               return flag.get();
               //FutureTask<V>  是实现了callable接口的任务，在线程中执行后的返回值，如果线程在执行或者未开始，就陷入阻塞状态
                // 直到任务执行完成，才有了返回值
            }catch (CancellationException e){
                cache.remove(arg,flag);
            } catch (ExecutionException e){
                e.printStackTrace();
            }

        }
    }
}
