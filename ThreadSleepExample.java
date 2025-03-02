class ThreadOne extends Thread {
    public void run() {
        while (true) {
            System.out.println("Thread 1");
            try {
                Thread.sleep(1000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread 1 interrupted.");
            }
        }
    }
}

class ThreadTwo extends Thread {
    public void run() {
        while (true) {
            System.out.println("Thread 2");
            try {
                Thread.sleep(2000); // Pause for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Thread 2 interrupted.");
            }
        }
    }
}

public class ThreadSleepExample {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        
        t1.start();
        t2.start(); 
    }
}
