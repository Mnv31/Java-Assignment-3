class NumberPrinter extends Thread {
    private volatile boolean running = true; // Volatile flag for safe stopping

    public void run() {
        int i = 1;
        while (running && i <= 100) {
            System.out.println(i);
            i++;
            try {
                Thread.sleep(500); // Simulate work (0.5 sec delay)
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        }
        System.out.println("Thread stopped.");
    }

    // Method to stop the thread safely
    public void stopThread() {
        running = false;
    }
}

public class StopThreadExample {
    public static void main(String[] args) {
        NumberPrinter thread = new NumberPrinter();
        thread.start();

        try {
            Thread.sleep(5000); // Let the thread run for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Stopping the thread...");
        thread.stopThread(); // Stop the thread safely
    }
}
