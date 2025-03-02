import java.util.LinkedList;

class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private final int CAPACITY = 5; // Max buffer size

    // Producer method
    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == CAPACITY) {
            System.out.println("Buffer full! Producer waiting...");
            wait(); // Wait if buffer is full
        }

        buffer.add(value);
        System.out.println("Produced: " + value);
        notify(); // Notify consumer that new data is available
    }

    // Consumer method
    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty! Consumer waiting...");
            wait(); // Wait if buffer is empty
        }

        int value = buffer.removeFirst();
        System.out.println("Consumed: " + value);
        notify(); // Notify producer that space is available
        return value;
    }
}

// Producer Thread
class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int value = 1;
        while (true) {
            try {
                buffer.produce(value++);
                Thread.sleep(1000); // Simulate time taken to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(1500); // Simulate time taken to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main Class
public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
