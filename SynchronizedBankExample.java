class BankAccount {
    private int balance = 1000; // Initial balance

    // Synchronized method to deposit money
    public synchronized void deposit(int amount, String threadName) {
        System.out.println(threadName + " is trying to deposit: $" + amount);
        int newBalance = balance + amount;
        try {
            Thread.sleep(500); // Simulate some processing time
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        balance = newBalance;
        System.out.println(threadName + " deposited: $" + amount + " | New Balance: $" + balance);
    }

    public int getBalance() {
        return balance;
    }
}

class BankThread extends Thread {
    private BankAccount account;
    private int amount;

    public BankThread(BankAccount account, int amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount, getName());
    }
}

public class SynchronizedBankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Two threads trying to deposit money
        BankThread t1 = new BankThread(account, 500, "Thread 1");
        BankThread t2 = new BankThread(account, 700, "Thread 2");

        t1.start();
        t2.start();
    }
}
