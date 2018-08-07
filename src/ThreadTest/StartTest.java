package ThreadTest;

public class StartTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);  //主线程休眠
                }catch (InterruptedException e){

                }
                System.out.print("2"); //1
            }
        });
        t.start();

        t.join();
        System.out.print("1"); //2
    }
}
