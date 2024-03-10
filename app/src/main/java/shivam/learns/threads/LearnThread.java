package shivam.learns.threads;

public class LearnThread extends Thread {

    @Override
    public void run() {
        System.out.println("Whattafuck from thread - "+Thread.currentThread().getName());
    }
}
