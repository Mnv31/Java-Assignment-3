class PriorityThread extends Thread {
    private String threadName;

    public PriorityThread(String name) {
        this.threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " is running.");
            try {
                Thread.sleep(500); // Sleep for 500ms
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread("Low Priority Thread");
        PriorityThread t2 = new PriorityThread("Medium Priority Thread");
        PriorityThread t3 = new PriorityThread("High Priority Thread");

        t1.setPriority(Thread.MIN_PRIORITY); // Lowest priority (1)
        t2.setPriority(Thread.NORM_PRIORITY); // Normal priority (5)
        t3.setPriority(Thread.MAX_PRIORITY); // Highest priority (10)
        t1.start();
        t2.start();
        t3.start();
    }
}
