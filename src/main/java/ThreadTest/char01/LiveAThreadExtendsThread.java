package ThreadTest.char01;

public class LiveAThreadExtendsThread extends Thread{
    public LiveAThreadExtendsThread(){
          System.out.println(Thread.currentThread().getName());
    }
    @Override
    public void run() {
        super.run();
        System.out.println("Thread.currentThread().getName=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new LiveAThreadExtendsThread().start();
    }
}
