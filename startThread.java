class HelloRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello, World!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public static void startThread() { // Custom method
        Thread thread = new Thread(new HelloRunnable());
        thread.start();
    }

    public static void main(String[] args) { 
        startThread(); // Calling custom method
    }
}
