class DaemonExample extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon Thread Running");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println("Daemon Thread Interrupted");
            }
        }
    }

    public static void main(String[] args) {
        DaemonExample daemonThread = new DaemonExample();
        daemonThread.setDaemon(true); // Set thread as Daemon
        daemonThread.start(); // Start daemon thread

        // Main thread prints messages every 2 seconds
        for (int i = 1; i <= 3; i++) {
            System.out.println("Main Thread Running");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Main Thread Interrupted");
            }
        }

        System.out.println("Main Thread Exiting... Daemon thread will stop.");
    }
}
