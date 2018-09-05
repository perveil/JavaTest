package ThreadTest;
//直接继承Thread
class SimpleThread extends Thread{
    private int countDown=5;
    private static  int id=0;
    SimpleThread(){
        super(Integer.toString(++id));
        start();
    }

    @Override
    public String toString() {
        return "this "+countDown;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (countDown--==0) break;
        }
    }
}
//自管理的Runable
class SelfRunable implements Runnable{
    private int countDown=5;
    private static  int id=0;
    Thread thread=new Thread(this);

    SelfRunable(){

        thread.start();
    }
    @Override
    public String toString() {
        return "this "+countDown;
    }
    @Override
    public void run() {
        while (true){
            System.out.println(this);
            if (countDown--==0) break;
        }

    }
}
public class ThreadTest {
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new SimpleThread();
        }
        new SelfRunable();
    }
}
