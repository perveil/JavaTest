package ThreadTest;

class Sleeper extends Thread{
    private int Sleeptime;
    Sleeper(String name,int Sleep){
        super(name);
        Sleeptime=Sleep;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(Sleeptime);
        }catch (InterruptedException e){
            System.out.println(getName()+"is Interrupted");
        }
        System.out.println(getName()+" is awaked");
    }
}
class Joiner extends Thread{
    private Sleeper sleeper;

    Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }
    @Override
    public void run() {
       try{
           sleeper.join();
       }catch (InterruptedException e){
           /*
           * 当一个线程调用interrupt()方法时，该线程已经被中断，但是在异常被捕获时将清理这个标志，所以在catch语句中
           * isInterrupted() 的值一直是false
           * */
           System.out.println(getName()+" is Interrupted"+" "+isInterrupted());
       }
        System.out.println(getName()+" is awaked");
    }
}
public class Joining {
    public static void main(String[] args) {
      Sleeper sleeper=new Sleeper("sleeper",2000);
      Joiner joiner=new Joiner("joiner",sleeper);

      joiner.interrupt();
    }
}
