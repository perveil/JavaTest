package ThreadTest;

public class PrintlnABC {
    public static class Worker {
        Object lock = new Object();
        int flag = 1;

        public void PrintA() {
            synchronized (lock) {
                while (flag != 1) {
                    try {
                        lock.wait(); //释放锁，当前拥有该锁的线程进入等待状态，需要被唤醒，所以在执行打印之前要调用notify方法
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                    }
                }
                flag = 2;
                lock.notifyAll();  // 唤醒所有在等待该锁的线程
                System.out.print(Thread.currentThread().getName());
            }
        }

        public void PrintB() {
            synchronized (lock) {
                while (flag != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                    }
                }
                flag = 3;
                lock.notifyAll();
                System.out.print(Thread.currentThread().getName());
            }
        }

        public void PrintC() {
            synchronized (lock) {
                while (flag != 3) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                    }
                }
                flag = 1;
                lock.notifyAll();
                System.out.print(Thread.currentThread().getName());
            }
        }

    }

    public static void main(String[] args) {
        Worker worker = new Worker();

        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                worker.PrintA();
            }
        }, "A");
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                worker.PrintB();
            }
        }, "B");
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                worker.PrintC();
            }
        }, "C");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

